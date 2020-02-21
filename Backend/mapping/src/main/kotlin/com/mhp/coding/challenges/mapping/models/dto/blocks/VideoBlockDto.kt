package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType

data class VideoBlockDto(val url: String, val type: VideoBlockType) : ArticleBlockDto()
