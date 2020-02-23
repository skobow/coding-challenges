package com.mhp.coding.challenges.mapping.mappers.blocks

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class GalleryBlockMappingStrategyTest : AbstractArticleTest() {

    private lateinit var galleryBlockMappingStrategy: GalleryBlockMappingStrategy

    @Before
    fun setUp() {
        galleryBlockMappingStrategy = GalleryBlockMappingStrategy()
    }

    @Test
    fun canMap_should_return_true_for_GalleryBlock() {
        val galleryBlock = createGalleryBlock(listOf(1L), 0)
        val result = galleryBlockMappingStrategy.canMap(galleryBlock)

        assertThat(result).isTrue()
    }

    @Test
    fun canMap_should_return_false_for_other_blocks() {
        val otherBlock = createImageBlock(0L, 0)
        val result = galleryBlockMappingStrategy.canMap(otherBlock)

        assertThat(result).isFalse()
    }

    @Test
    fun doMap_should_mao_GalleryBlock_correctly() {
        val galleryBlock = createGalleryBlock(listOf(1L), 0)
        val (sortIndex, images) = galleryBlockMappingStrategy.doMap(galleryBlock)

        assertThat(sortIndex).isEqualTo(galleryBlock.sortIndex)
        assertThat(images.size).isEqualTo(galleryBlock.images.size)
    }
}