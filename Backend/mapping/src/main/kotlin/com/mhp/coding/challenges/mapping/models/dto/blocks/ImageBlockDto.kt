package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.dto.ImageDto

data class ImageBlockDto(override val sortIndex: Int, val image: ImageDto?) : ArticleBlockDto(sortIndex, "ImageBlock")
