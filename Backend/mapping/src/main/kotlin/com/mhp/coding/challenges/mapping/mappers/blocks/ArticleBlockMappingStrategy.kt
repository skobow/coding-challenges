package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto

interface ArticleBlockMappingStrategy<T : ArticleBlock> {
    fun map(block: ArticleBlock): ArticleBlockDto
    fun canMap(block: ArticleBlock): Boolean
}

abstract class AbstractArticleBlockMappingStrategy<T : ArticleBlock> : ArticleBlockMappingStrategy<T> {

    @Suppress("UNCHECKED_CAST")
    override fun map(block: ArticleBlock): ArticleBlockDto {
        val typedBlock = block as? T ?: throw IllegalArgumentException("Unsupported block type: [${block::class.simpleName}]")
        return safeMap(typedBlock)
    }

    private fun safeMap(block: T): ArticleBlockDto {
        return doMap(block)
    }

    internal abstract fun doMap(block: T): ArticleBlockDto
}