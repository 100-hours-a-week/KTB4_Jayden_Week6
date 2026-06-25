package com.example.spring_rest_api.article.service.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleDeleteRequest {
    @NotNull
    private Long userId;
}
