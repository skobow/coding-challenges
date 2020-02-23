package com.mhp.coding.challenges.mapping.mappers.blocks

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType
import java.util.ArrayList
import java.util.Date
import java.util.HashSet

abstract class AbstractArticleTest {

    fun createDummyArticle(id: Long): Article? {
        val result = Article()
        result.id = id
        result.author = "Max Mustermann"
        result.description = "Article Description $id"
        result.title = "Article Nr.: $id"
        result.lastModifiedBy = "Hans Müller"
        result.lastModified = Date()
        result.blocks = createDefaultBlocks(id)
        return result
    }

    fun createDefaultBlocks(articleId: Long): Set<ArticleBlock>? {
        val result: MutableSet<ArticleBlock> = HashSet()

        result.add(createTextBlock("Some Text for $articleId", 0))
        result.add(createImageBlock(1L, 1))
        result.add(createTextBlock("Second Text for $articleId", 2))
        result.add(createGalleryBlock(listOf(2L, 3L), 3))
        result.add(createTextBlock("Third Text for $articleId", 4))
        result.add(createVideoBlock(VideoBlockType.YOUTUBE, "https://youtu.be/myvideo", 5))

        return result
    }

    fun createTextBlock(text: String, sortIndex: Int): TextBlock {
        val textBlock = TextBlock()
        textBlock.text = text
        textBlock.sortIndex = sortIndex

        return textBlock
    }

    fun createImageBlock(imageId: Long, sortIndex: Int): ImageBlock {
        val imageBlock = ImageBlock()
        imageBlock.image = createImage(imageId)
        imageBlock.sortIndex = sortIndex

        return imageBlock
    }

    fun createVideoBlock(type: VideoBlockType, url: String, sortIndex: Int): VideoBlock {
        val videoBlock = VideoBlock()
        videoBlock.type = type
        videoBlock.url = url
        videoBlock.sortIndex = sortIndex

        return videoBlock
    }

    fun createGalleryBlock(imageIds: List<Long>, sortIndex: Int): GalleryBlock {
        val galleryBlock = GalleryBlock()
        galleryBlock.sortIndex = sortIndex
        val galleryImages: MutableList<Image> = ArrayList()
        imageIds.forEach {
            galleryImages.add(createImage(it))
        }
        galleryBlock.images = galleryImages

        return galleryBlock
    }

    fun createImage(imageId: Long): Image {
        val result = Image()

        result.id = imageId
        result.lastModified = Date()
        result.lastModifiedBy = "Max Mustermann"
        result.imageSize = ImageSize.LARGE
        result.url = "https://someurl.com/image/$imageId"

        return result
    }

}