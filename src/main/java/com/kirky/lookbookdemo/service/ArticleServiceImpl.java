package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ArticleDTO;
import com.kirky.lookbookdemo.model.Article;
import com.kirky.lookbookdemo.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public ArticleDTO getArticleByPath(String path) {
        Article article = articleRepository
                .findByPath(path)
                .orElseThrow(() -> new EntityNotFoundException("No article from : " + path));
        return convertToDTO(article);
    }

    @Override
    @Transactional
    public ArticleDTO addArticle(ArticleDTO articleDTO) {
        articleRepository.save(convertToEntity(articleDTO));
        return articleDTO;
    }

    private ArticleDTO convertToDTO(Article entity) {
        return modelMapper.map(entity, ArticleDTO.class);
    }

    private Article convertToEntity(ArticleDTO dto) {
        return modelMapper.map(dto, Article.class);
    }
}
