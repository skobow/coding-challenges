package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto
import com.mhp.coding.challenges.mapping.models.dto.toImageDto
import org.springframework.stereotype.Component

@Component
class GalleryBlockMappingStrategy : AbstractArticleBlockMappingStrategy<GalleryBlock>() {
    override fun canMap(block: ArticleBlock) = block is GalleryBlock

    override fun doMap(block: GalleryBlock) = GalleryBlockDto(block.sortIndex,
            block.images.map {
                it.toImageDto()
            })
}