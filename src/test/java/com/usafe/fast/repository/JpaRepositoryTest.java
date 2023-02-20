package com.usafe.fast.repository;

import com.usafe.fast.config.JpaConfig;
import com.usafe.fast.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;  //자동 import되지 않음
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

//    @DisplayName("select 테스트")
//    @Test
//    void givenTestData_whenSelecting_thenWorksFine(){
//        //Given
//
//        //WHen
//        List<Article> articles =  articleRepository.findAll();
//        //Then
//        assertThat(articles)
//                .isNotNull()
//                .hasSize(0);
//    }
//
//
//    @DisplayName("insert 테스트")
//    @Test
//    void givenTestData_whenInserting_thenWorksFine(){
//        //Given
//        long previousCount = articleRepository.count();
//        Article article = Article.of("new article","new content","#spring");
//        //WHen
//        articleRepository.save(article);
//        //Then
//        assertThat(articleRepository.count()).isEqualTo(previousCount+1);
//    }

//    @DisplayName("update 테스트")
//    @Test
//    void givenTestData_whenUpdating_thenWorksFine(){
//        //Given
//        Article article = Article.of("new article","new content","#spring");
//        articleRepository.save(article);
//        Article selectArticle = articleRepository.findById(1L).orElseThrow();
//        String updatedHashTag = "#springboot";
//        selectArticle.setHashtag(updatedHashTag);
//
//        //WHen
//        Article updateArticle = articleRepository.saveAndFlush(selectArticle);
//
//        //Then
//        assertThat(updateArticle)
//                .hasFieldOrPropertyWithValue("hashtag",updatedHashTag);
//
//    }

    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //Given
        Article article = Article.of("new article","new content","#spring");
        articleRepository.save(article);
        Article selectArticle = articleRepository.findById(1L).orElseThrow();
        //WHen
        articleRepository.delete(selectArticle);

        Long currentCount = articleRepository.count();

        //Then
        assertThat(currentCount)
                .isEqualTo(0);

    }

}