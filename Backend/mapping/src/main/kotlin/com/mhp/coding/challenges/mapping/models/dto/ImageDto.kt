package com.mhp.coding.challenges.mapping.models.dto

import com.mhp.coding.challenges.mapping.models.db.ImageSize

data class ImageDto(val id: Long, val url: String, val imageSize: ImageSize)