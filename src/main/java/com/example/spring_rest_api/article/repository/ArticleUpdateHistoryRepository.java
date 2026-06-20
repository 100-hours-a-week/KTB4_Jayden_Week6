package com.example.spring_rest_api.article.repository;

import com.example.spring_rest_api.article.entity.ArticleUpdateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleUpdateHistoryRepository extends JpaRepository<ArticleUpdateHistory, Long> {
}
