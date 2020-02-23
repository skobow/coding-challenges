package com.mhp.coding.challenges.mapping.models.dto.blocks

data class TextBlockDto(override val sortIndex: Int, val text: String) : ArticleBlockDto(sortIndex, "TextBlock")