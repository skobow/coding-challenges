package com.mhp.coding.challenges.mapping.models.dto.blocks

import com.mhp.coding.challenges.mapping.models.dto.ImageDto

data class GalleryBlockDto(val images: List<ImageDto>) : ArticleBlockDto()
