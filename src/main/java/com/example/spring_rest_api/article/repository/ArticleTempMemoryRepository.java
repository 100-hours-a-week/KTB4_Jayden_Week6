package com.example.spring_rest_api.article.repository;

import com.example.spring_rest_api.article.entity.Article;
import com.example.spring_rest_api.common.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleTempMemoryRepository {
    // <userId, Article>
    private final Map<Long, Article> articleTempStorage = new ConcurrentHashMap<>();

    public Article save(Article article) {
        articleTempStorage.put(article.getUserId(), article);
        return articleTempStorage.get(article.getUserId());
    }

    public Article read(Long userId) {
        return Optional.ofNullable(articleTempStorage.get(userId))
                .orElseThrow(() -> new NotFoundException("ARTICLE_TEMP_NOT_FOUND"));
    }
}
