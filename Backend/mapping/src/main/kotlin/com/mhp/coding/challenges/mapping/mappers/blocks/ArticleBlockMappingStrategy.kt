package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import kotlin.reflect.KClass
import kotlin.reflect.full.cast

interface ArticleBlockMappingStrategy {
    fun map(block: ArticleBlock): ArticleBlockDto
    fun canMap(blockType: Class<*>): Boolean
}

abstract class AbstractArticleBlockMappingStrategy<T : ArticleBlock>(private val blockType: KClass<T>) : ArticleBlockMappingStrategy {

    override fun canMap(blockType: Class<*>) = blockType == this.blockType.java

    init {
        this::class
    }
    override fun map(block: ArticleBlock): ArticleBlockDto {
        return if (blockType.isInstance(block))
            safeMap(blockType.cast(block))
        else
            throw IllegalArgumentException("Unsupported block type: [${block::class.simpleName}]")
    }

    private fun safeMap(block: T): ArticleBlockDto {
        return doMap(block)
    }

    internal abstract fun doMap(block: T): ArticleBlockDto
}