package com.kirky.lookbookdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import javax.swing.text.StringContent;
import java.util.List;

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

    @JsonBackReference
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Content> content;

    @JsonBackReference
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Image> images;
}
