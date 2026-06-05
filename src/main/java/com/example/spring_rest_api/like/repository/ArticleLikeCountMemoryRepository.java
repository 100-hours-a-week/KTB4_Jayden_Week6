package com.example.spring_rest_api.like.repository;

import com.example.spring_rest_api.like.entity.ArticleLikeCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ArticleLikeCountMemoryRepository {
    // <articleId, ArticleLikeCount>
    private final Map<Long, ArticleLikeCount> articleLikeCountStorage =  new ConcurrentHashMap<>();

    public Long read(Long articleId) {
        return articleLikeCountStorage.containsKey(articleId) ?
                articleLikeCountStorage.get(articleId).getLikeCount() :
                0L;
    }

    public void increase(Long articleId) {
        if (articleLikeCountStorage.containsKey(articleId)) {
            articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId).increase());
        } else {
            articleLikeCountStorage.put(articleId, ArticleLikeCount.init(articleId, 1L));
        }
    }

    public void decrease(Long articleId) {
        if (articleLikeCountStorage.containsKey(articleId)) {
            articleLikeCountStorage.put(articleId, articleLikeCountStorage.get(articleId).decrease());
        } else {
            articleLikeCountStorage.put(articleId, ArticleLikeCount.init(articleId, 0L));
        }
    }
}
