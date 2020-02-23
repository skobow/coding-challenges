package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType

data class VideoBlockDto(override val sortIndex: Int, val url: String, val type: VideoBlockType)
    : ArticleBlockDto(sortIndex, "VideoBlock")
