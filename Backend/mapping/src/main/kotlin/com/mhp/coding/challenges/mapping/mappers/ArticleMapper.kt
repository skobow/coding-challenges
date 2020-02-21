package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.mappers.blocks.ArticleBlockMapper
import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.stereotype.Component

@Component
class ArticleMapper(private val blockMapper: ArticleBlockMapper) {

    fun map(article: Article): ArticleDto = ArticleDto(
                article.id,
                article.title,
                article.description,
                article.author,
                blockMapper.mapAll(article.blocks))

    fun map(articleDto: ArticleDto): Article {
        // Nicht Teil dieser Challenge.
        return Article()
    }
}