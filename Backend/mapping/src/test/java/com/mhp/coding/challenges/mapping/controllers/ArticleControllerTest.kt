package com.mhp.coding.challenges.mapping.controllers

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun details_for_non_existing_article_should_return_404() {
        mockMvc.perform(get("/article/1234567890")).andExpect(status().isNotFound)
    }

    @Test
    fun details_for_non_existing_article_should_return_200() {
        mockMvc.perform(get("/article/1001")).andExpect(status().isOk)
    }

    @Test
    fun list_articles_should_return_json() {
        mockMvc.perform(get("/article"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }
}