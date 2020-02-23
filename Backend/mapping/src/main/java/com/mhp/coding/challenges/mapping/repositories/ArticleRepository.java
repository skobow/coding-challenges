package com.mhp.coding.challenges.mapping.repositories;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.Image;
import com.mhp.coding.challenges.mapping.models.db.ImageSize;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlockType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ArticleRepository {

    private final List<Article> articles = new ArrayList<>();

    public ArticleRepository() {
        articles.add(createDummyArticle(1001L));
        articles.add(createDummyArticle(2002L));
        articles.add(createDummyArticle(3003L));
        articles.add(createDummyArticle(4004L));
        articles.add(createDummyArticle(5005L));
    }

    public List<Article> all(){
        return articles;
    }

    public Optional<Article> findBy(Long id){
        return articles.stream()
                .filter(article -> id.equals(article.getId()))
                .findFirst();
    }

    public void create(Article article){
        //Ignore
    }

    private Article createDummyArticle(Long id) {
        final Article result = new Article();
        result.setId(id);
        result.setAuthor("Max Mustermann");
        result.setDescription("Article Description " + id);
        result.setTitle("Article Nr.: " + id);
        result.setLastModifiedBy("Hans Müller");
        result.setLastModified(new Date());
        result.setBlocks(createBlocks(id));
        return result;
    }

    private Set<ArticleBlock> createBlocks(Long articleId){
        final Set<ArticleBlock> result = new HashSet<>();

        final TextBlock textBlock = new TextBlock();
        textBlock.setText("Some Text for " + articleId);
        textBlock.setSortIndex(0);
        result.add(textBlock);

        final ImageBlock imageBlock = new ImageBlock();
        imageBlock.setImage(createImage(1L));
        imageBlock.setSortIndex(1);
        result.add(imageBlock);

        final TextBlock secondTextBlock = new TextBlock();
        secondTextBlock.setText("Second Text for " + articleId);
        secondTextBlock.setSortIndex(2);
        result.add(secondTextBlock);

        final GalleryBlock galleryBlock = new GalleryBlock();
        galleryBlock.setSortIndex(3);

        final List<Image> galleryImages = new ArrayList<>();
        galleryImages.add(createImage(2L));
        galleryImages.add(createImage(3L));
        galleryBlock.setImages(galleryImages);

        result.add(galleryBlock);

        final TextBlock thirdTextBlock = new TextBlock();
        thirdTextBlock.setText("Third Text for " + articleId);
        thirdTextBlock.setSortIndex(4);
        result.add(thirdTextBlock);

        final VideoBlock videoBlock = new VideoBlock();
        videoBlock.setType(VideoBlockType.YOUTUBE);
        videoBlock.setUrl("https://youtu.be/myvideo");
        videoBlock.setSortIndex(5);

        result.add(videoBlock);

        return result;
    }

    private Image createImage(Long imageId){
        final Image result = new Image();
        result.setId(imageId);
        result.setLastModified(new Date());
        result.setLastModifiedBy("Max Mustermann");
        result.setImageSize(ImageSize.LARGE);
        result.setUrl("https://someurl.com/image/" + imageId);
        return result;
    }
}
