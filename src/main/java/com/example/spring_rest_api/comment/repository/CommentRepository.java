package com.example.spring_rest_api.comment.repository;

import com.example.spring_rest_api.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("""
                select c.commentId, c.user.userId, c.commentText, c.parentCommentId, c.createdAt, c.deletedAt, c.updatedAt
                    from Comment c
                    where c.article.articleId = :articleId
                    order by c.parentCommentId asc, c.commentId asc
                    limit :pageSize
            """)
    List<Comment> findAllInfiniteScroll(Long articleId, Long pageSize);

    @Query("""
                select c.commentId, c.user.userId, c.commentText, c.parentCommentId, c.createdAt, c.deletedAt, c.updatedAt
                    from Comment c
                    where c.article.articleId = :articleId
                        and (c.parentCommentId > :lastParentCommentId or
                            (c.parentCommentId = :lastParentCommentId and c.commentId > :lastCommentId))
                    order by c.parentCommentId asc, c.commentId asc
                    limit :pageSize
            """)
    List<Comment> findAllInfiniteScroll(Long articleId, Long pageSize, Long lastParentCommentId, Long lastCommentId);
}
