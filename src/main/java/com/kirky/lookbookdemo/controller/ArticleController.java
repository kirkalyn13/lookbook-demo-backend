package com.kirky.lookbookdemo.controller;

import com.kirky.lookbookdemo.dto.ArticleDTO;
import com.kirky.lookbookdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/{path}")
    public ResponseEntity<List<ArticleDTO>> getArticlesByPath(@PathVariable("path") String path) {
        List<ArticleDTO> results = articleService.getArticlesByPath(path);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO result = articleService.addArticle(articleDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
