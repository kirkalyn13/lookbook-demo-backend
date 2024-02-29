package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ArticleDTO;
import com.kirky.lookbookdemo.model.Article;


public interface ArticleService {
    ArticleDTO getArticleByPath(String path);
    ArticleDTO addArticle(ArticleDTO articleDTO);
}
