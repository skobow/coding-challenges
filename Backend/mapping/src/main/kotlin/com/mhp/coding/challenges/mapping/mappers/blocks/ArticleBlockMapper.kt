package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ArticleBlockMapper(private val strategies: List<ArticleBlockMappingStrategy<*>>) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val log = LoggerFactory.getLogger(javaClass.enclosingClass)
    }

    fun mapAll(blocks: Set<ArticleBlock>): List<ArticleBlockDto> = blocks.mapNotNull(this::map)

    fun map(block: ArticleBlock): ArticleBlockDto? =
            getMappingStrategyFor(block)?.map(block) ?: run {
                log.warn("No mapper found for block type: [${block::class.java.name}]")
                null
            }

    private fun getMappingStrategyFor(block: ArticleBlock): ArticleBlockMappingStrategy<*>? =
            strategies.firstOrNull {
                it.canMap(block)
            }
}