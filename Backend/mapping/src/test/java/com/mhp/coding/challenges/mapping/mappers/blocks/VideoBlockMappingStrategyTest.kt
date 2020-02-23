package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class VideoBlockMappingStrategyTest : AbstractArticleTest() {

    private lateinit var videoBlockMappingStrategy: VideoBlockMappingStrategy

    @Before
    fun setUp() {
        videoBlockMappingStrategy = VideoBlockMappingStrategy()
    }

    @Test
    fun canMap_should_return_true_for_VideoBlock() {
        val videoBlock = createVideoBlock(VideoBlockType.YOUTUBE, "AN_URL", 0)
        val result = videoBlockMappingStrategy.canMap(videoBlock)

        assertThat(result).isTrue()
    }

    @Test
    fun canMap_should_return_false_for_other_blocks() {
        val textBlock = createTextBlock("TEXT", 0)
        val result = videoBlockMappingStrategy.canMap(textBlock)

        assertThat(result).isFalse()
    }

    @Test
    fun doMap_should_map_VideoBlock_correctly() {
        val videoBlock = createVideoBlock(VideoBlockType.YOUTUBE, "AN_URL", 0)
        val (sortIndex, url, type) = videoBlockMappingStrategy.doMap(videoBlock)

        assertThat(sortIndex).isEqualTo(videoBlock.sortIndex)
        assertThat(url).isEqualTo(videoBlock.url)
        assertThat(type).isEqualTo(videoBlock.type)
    }
}