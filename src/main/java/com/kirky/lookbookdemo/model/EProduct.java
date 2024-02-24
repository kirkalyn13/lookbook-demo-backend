package com.kirky.lookbookdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class EProduct {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail")
    private String thumbnail;
}
