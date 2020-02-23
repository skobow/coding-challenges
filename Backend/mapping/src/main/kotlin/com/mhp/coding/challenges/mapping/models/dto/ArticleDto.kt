package com.mhp.coding.challenges.mapping.models.dto

import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto

data class ArticleDto(val id: Long, val title: String, val description: String, val author: String, val blocks: Collection<ArticleBlockDto>)
