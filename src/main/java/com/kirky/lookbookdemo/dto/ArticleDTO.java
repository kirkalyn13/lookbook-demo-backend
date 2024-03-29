package com.kirky.lookbookdemo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ArticleDTO implements Serializable {
    private Integer id;
    private String title;
    private String path;
    private String subtitle;
    private List<ContentDTO> content;
    private List<ImageDTO> images;
}
