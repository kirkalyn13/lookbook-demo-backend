package com.kirky.lookbookdemo.repository;

import com.kirky.lookbookdemo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findArticlesByPath(String path);
}
