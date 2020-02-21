package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Objects
import java.util.stream.Collectors

@Component
class ArticleBlockMapper(private val strategies: List<ArticleBlockMappingStrategy>) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val log = LoggerFactory.getLogger(javaClass.enclosingClass)
    }

    fun mapAll(blocks: Set<ArticleBlock>): Set<ArticleBlockDto?> {
        return blocks.stream()
                .map(this::map)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet())
    }

    fun map(block: ArticleBlock): ArticleBlockDto? {
        val strategy = getStrategyFor(block::class.java)
        if (strategy == null) {
            log.warn("No mapper found for block type: [${block::class.java.name}]")
            return null
        }
        return strategy.map(block)
    }

    private fun getStrategyFor(blockType: Class<*>): ArticleBlockMappingStrategy? {
        return strategies.firstOrNull {
            it.canMap(blockType)
        }
    }
}