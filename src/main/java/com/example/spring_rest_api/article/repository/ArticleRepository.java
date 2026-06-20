package com.example.spring_rest_api.article.repository;

import com.example.spring_rest_api.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("""
                select a.articleId, a.user.userId, a.title, a.content, a.contentImages, a.createdAt,
                        a.articleStat.commentCount, a.articleStat.articleLikeCount, a.articleStat.articleViewCount
                    from Article a
                    where a.deletedAt is null and a.isArticleHidden is false
                    order by a.articleId desc
                    limit :pageSize
            """)
    List<Article> findAllInfiniteScroll(Long pageSize);

    @Query("""
                select a.articleId, a.user.userId, a.title, a.content, a.contentImages, a.createdAt,
                        a.articleStat.commentCount, a.articleStat.articleLikeCount, a.articleStat.articleViewCount
                    from Article a
                    where a.articleId < :lastArticleId and a.deletedAt is null and a.isArticleHidden is false
                    order by a.articleId desc
                    limit :pageSize
            """)
    List<Article> findAllInfiniteScroll(Long pageSize, Long lastArticleId);

    @Query("""
                select count(a)
                    from Article a
                    where a.user.userId = :userId and a.createdAt >= :localDateTimeMinusMinuteOne
            """)
    int countWithinOneMinute(Long userId, LocalDateTime localDateTimeMinusMinuteOne);
}
