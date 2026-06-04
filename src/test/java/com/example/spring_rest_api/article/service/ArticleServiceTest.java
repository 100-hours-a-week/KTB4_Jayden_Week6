package com.example.spring_rest_api.article.service;

import com.example.spring_rest_api.article.entity.Article;
import com.example.spring_rest_api.article.repository.ArticleMemoryRepository;
import com.example.spring_rest_api.article.service.response.ArticleResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArticleServiceTest {
    final ArticleMemoryRepository articleMemoryRepository = new ArticleMemoryRepository();
    final ArticleService articleService = new ArticleService(articleMemoryRepository);

    private Long sequence = 0L;


    @Test
    void readInfiniteScroll() {
        //given
        for (Long i = 0L ; i < 50L; i++) {
            articleMemoryRepository.save(Article.create(
                    sequence++,
                    String.valueOf(i),
                    String.valueOf(i),
                    i,
                    List.of(String.valueOf(i))
            ));
            System.out.println(i);
        }

        //when
        List<ArticleResponse> responses1 = articleService.readInfiniteScroll(10L, null);
        List<ArticleResponse> responses2 = articleService.readInfiniteScroll(10L, 10L);
        List<ArticleResponse> responses3 = articleService.readInfiniteScroll(10L, 5L);

        //then
        System.out.println(responses1);
        System.out.println(responses2);
        System.out.println(responses3);
    }




}