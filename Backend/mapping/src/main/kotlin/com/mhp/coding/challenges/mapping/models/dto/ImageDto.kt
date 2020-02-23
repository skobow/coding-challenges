package com.mhp.coding.challenges.mapping.models.dto

import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize

data class ImageDto(val id: Long, val url: String, val imageSize: ImageSize)

fun Image.toImageDto() = ImageDto(this.id, this.url, this.imageSize)