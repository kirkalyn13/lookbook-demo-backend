package com.kirky.lookbookdemo.controller;

import com.kirky.lookbookdemo.dto.ArticleDTO;
import com.kirky.lookbookdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/{path}")
    public ResponseEntity<ArticleDTO> getArticleByPath(@PathVariable("path") String path) {
        ArticleDTO result = articleService.getArticleByPath(path);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO result = articleService.addArticle(articleDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
