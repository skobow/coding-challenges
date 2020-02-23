package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.mappers.blocks.AbstractArticleTest
import com.mhp.coding.challenges.mapping.mappers.blocks.ArticleBlockMapper
import com.mhp.coding.challenges.mapping.mappers.blocks.TextBlockMappingStrategy
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ArticleMapperTest : AbstractArticleTest() {

    private lateinit var mapperUnderTest: ArticleMapper

    @Before
    fun setUp() {
        mapperUnderTest = ArticleMapper(ArticleBlockMapper(mutableListOf(TextBlockMappingStrategy())))
    }

    @Test
    fun map_should_map_Article_correctly() {
        val dummyArticle = createDummyArticle(1001L)!!
        dummyArticle.blocks = mutableSetOf(createTextBlock("TEXT", 0)) as Set<ArticleBlock>?

        val (id, title, description, author, blocks) = mapperUnderTest.map(dummyArticle)

        assertThat(id).isEqualTo(dummyArticle.id)
        assertThat(title).isEqualTo(dummyArticle.title)
        assertThat(description).isEqualTo(dummyArticle.description)
        assertThat(author).isEqualTo(dummyArticle.author)

        assertThat(blocks.size).isEqualTo(dummyArticle.blocks.size)
    }

    @Test
    fun map_should_return_sorted_list() {

        val dummyArticle = createDummyArticle(1001L)!!

        val unsortedBlocks = setOf(
                createTextBlock("BLOCK_1", 1),
                createTextBlock("BLOCK_0", 0),
                createTextBlock("BLOCK_4", 4),
                createTextBlock("BLOCK_2", 2),
                createTextBlock("BLOCK_3", 3)
        )

        dummyArticle.blocks = unsortedBlocks
        val articleDto = mapperUnderTest.map(dummyArticle)
        val sortedBlocks = ArrayList(articleDto.blocks)

        assertThat(sortedBlocks).isSortedAccordingTo(ArticleBlockDtoComparator())
    }

    private class ArticleBlockDtoComparator: Comparator<ArticleBlockDto> {
        override fun compare(o1: ArticleBlockDto, o2: ArticleBlockDto): Int = o1.sortIndex.compareTo(o2.sortIndex)
    }
}