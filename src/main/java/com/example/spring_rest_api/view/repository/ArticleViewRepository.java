package com.example.spring_rest_api.view.repository;

import com.example.spring_rest_api.view.entity.ArticleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleViewRepository extends JpaRepository<ArticleView, Long> {

    Optional<ArticleView> findByArticle_ArticleIdAndUser_UserId(Long articleId, Long userId);
}
