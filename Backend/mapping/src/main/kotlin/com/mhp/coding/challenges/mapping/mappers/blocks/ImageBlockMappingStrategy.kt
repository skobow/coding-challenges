package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto
import com.mhp.coding.challenges.mapping.models.dto.toImageDto
import org.springframework.stereotype.Component

@Component
class ImageBlockMappingStrategy : AbstractArticleBlockMappingStrategy<ImageBlock>() {
    override fun canMap(block: ArticleBlock) = block is ImageBlock

    override fun doMap(block: ImageBlock) = ImageBlockDto(
                block.sortIndex,
                block.image?.toImageDto())
}