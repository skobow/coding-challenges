package com.mhp.coding.challenges.mapping.controllers

import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.services.ArticleService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/article"], produces = [MediaType.APPLICATION_JSON_VALUE])
class ArticleController(private val articleService: ArticleService) {

    @GetMapping
    fun list(): List<ArticleDto> {
        return articleService.list()
    }

    @GetMapping("/{id}")
    fun details(@PathVariable id: Long): ResponseEntity<ArticleDto> =
            articleService.articleForId(id)?.let {
                ResponseEntity.ok(it)
            } ?: ResponseEntity.notFound().build()

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody articleDto: ArticleDto): ArticleDto {
        return articleService.create(articleDto)
    }
}
