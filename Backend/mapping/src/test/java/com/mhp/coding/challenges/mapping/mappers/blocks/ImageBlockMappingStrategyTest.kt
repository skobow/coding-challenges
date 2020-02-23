package com.mhp.coding.challenges.mapping.mappers.blocks

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ImageBlockMappingStrategyTest : AbstractArticleTest() {

    private lateinit var imageBlockMappingStrategy: ImageBlockMappingStrategy

    @Before
    fun setUp() {
        imageBlockMappingStrategy = ImageBlockMappingStrategy()
    }

    @Test
    fun canMap_should_return_true_for_ImageBlock() {
        val imageBlock = createImageBlock(1L, 0)
        val result = imageBlockMappingStrategy.canMap(imageBlock)

        assertThat(result).isTrue()
    }

    @Test
    fun canMap_should_return_false_for_other_blocks() {
        val textBlock = createTextBlock("TEXT", 0)
        val result = imageBlockMappingStrategy.canMap(textBlock)

        assertThat(result).isFalse()
    }

    @Test
    fun doMap_should_map_ImageBlock_correctly() {
        val imageBlock = createImageBlock(1L, 0)
        val (sortIndex, image) = imageBlockMappingStrategy.doMap(imageBlock)

        assertThat(sortIndex).isEqualTo(imageBlock.sortIndex)
        assertThat(image).isNotNull
        assertThat(image?.id).isEqualTo(imageBlock.image.id)
        assertThat(image?.imageSize).isEqualTo(imageBlock.image.imageSize)
        assertThat(image?.url).isEqualTo(imageBlock.image.url)
    }
}