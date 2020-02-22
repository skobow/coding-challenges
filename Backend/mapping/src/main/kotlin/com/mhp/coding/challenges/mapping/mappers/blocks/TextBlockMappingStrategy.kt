package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlockDto
import org.springframework.stereotype.Component

@Component
class TextBlockMappingStrategy : AbstractArticleBlockMappingStrategy<TextBlock>() {

    override fun canMap(block: ArticleBlock) = block is TextBlock

    override fun doMap(block: TextBlock) = TextBlockDto(block.sortIndex, block.text)
}