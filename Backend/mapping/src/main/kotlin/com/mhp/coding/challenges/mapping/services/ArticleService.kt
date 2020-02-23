package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.mappers.ArticleMapper
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class ArticleService(private val repository: ArticleRepository, private val mapper: ArticleMapper) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        @JvmStatic
        private val log = LoggerFactory.getLogger(javaClass.enclosingClass)
    }

    fun list(): List<ArticleDto> = repository.all().map(mapper::map)

    fun articleForId(id: Long): ArticleDto? =
            repository.findBy(id)
                    .map(mapper::map)
                    .orElseGet {
                        log.info("Unable to find article with id [{}]", id)
                        null
                    }

    fun create(articleDto: ArticleDto): ArticleDto {
        val create = mapper.map(articleDto)
        repository.create(create)
        return mapper.map(create)
    }
}
