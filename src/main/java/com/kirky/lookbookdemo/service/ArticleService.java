package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ArticleDTO;
import com.kirky.lookbookdemo.model.Article;

import java.util.List;


public interface ArticleService {
    List<ArticleDTO> getArticlesByPath(String path);
    ArticleDTO addArticle(ArticleDTO articleDTO);
}
