package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlockDto
import org.springframework.stereotype.Component

@Component
class VideoBlockMappingStrategy : AbstractArticleBlockMappingStrategy<VideoBlock>() {
    override fun canMap(block: ArticleBlock) = block is VideoBlock

    override fun doMap(block: VideoBlock) = VideoBlockDto(block.sortIndex, block.url, block.type)
}