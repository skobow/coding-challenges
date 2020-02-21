package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock
import com.mhp.coding.challenges.mapping.models.dto.ImageDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlockDto
import org.springframework.stereotype.Component

@Component
class ImageBlockMappingStrategy : AbstractArticleBlockMappingStrategy<ImageBlock>(ImageBlock::class) {
    override fun doMap(block: ImageBlock): ArticleBlockDto {
        return ImageBlockDto(
                ImageDto(
                        block.image.id,
                        block.image.url,
                        block.image.imageSize
                ))
    }
}