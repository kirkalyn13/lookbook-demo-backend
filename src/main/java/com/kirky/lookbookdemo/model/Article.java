package com.kirky.lookbookdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "articles")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "path")
    private String path;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @Column(name = "caption")
    private String caption;
}
