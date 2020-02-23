package com.mhp.coding.challenges.mapping.mappers.blocks

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class TextBlockMappingStrategyTest : AbstractArticleTest() {

    private lateinit var textBlockMappingStrategy: TextBlockMappingStrategy

    @Before
    fun setup() {
        textBlockMappingStrategy = TextBlockMappingStrategy()
    }

    @Test
    fun canMap_should_return_true_for_TextBlock() {
        val textBlock = createTextBlock("TEXT", 0)
        val result = textBlockMappingStrategy.canMap(textBlock)

        assertThat(result).isTrue()
    }

    @Test
    fun canMap_should_return_false_for_other_blocks() {
        val otherBlock = createImageBlock(0L, 0)
        val result = textBlockMappingStrategy.canMap(otherBlock)

        assertThat(result).isFalse()
    }

    @Test
    fun doMap_should_map_TextBlock_correctly() {
        val textBlock = createTextBlock("TEXT", 0)
        val (sortIndex, text) = textBlockMappingStrategy.doMap(textBlock)

        assertThat(sortIndex).isEqualTo(textBlock.sortIndex)
        assertThat(text).isEqualTo(textBlock.text)
    }
}