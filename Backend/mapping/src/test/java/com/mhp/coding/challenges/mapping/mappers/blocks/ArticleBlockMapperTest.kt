package com.mhp.coding.challenges.mapping.mappers.blocks

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.read.ListAppender
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory

class ArticleBlockMapperTest : AbstractArticleTest() {

    private lateinit var mapperUnderTest: ArticleBlockMapper

    @Before
    fun setUp() {
        mapperUnderTest = ArticleBlockMapper(ArrayList())
    }

    @Test
    fun map_should_log_ArticleBlocks_without_mapper_and_return_null() {

        val logger = LoggerFactory.getLogger(ArticleBlockMapper::class.java) as Logger
        val listAppender = ListAppender<ILoggingEvent>()
        listAppender.start()
        logger.addAppender(listAppender)

        val textBlock = createTextBlock("Block without mapper", 0)
        val textBlockDto = mapperUnderTest.map(textBlock)

        assertThat(textBlockDto).isNull()
        assertThat(listAppender.list)
                .extracting("message", "level")
                .contains(Tuple.tuple("No mapper found for block type: [${TextBlock::class}]", Level.WARN))
    }
}