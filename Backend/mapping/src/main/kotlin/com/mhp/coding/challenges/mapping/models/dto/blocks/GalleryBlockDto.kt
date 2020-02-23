package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.dto.ImageDto

data class GalleryBlockDto(override val sortIndex: Int, val images: List<ImageDto>) : ArticleBlockDto(sortIndex, "GalleryBlock")
