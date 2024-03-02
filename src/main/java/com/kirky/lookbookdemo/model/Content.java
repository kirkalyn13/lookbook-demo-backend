package com.kirky.lookbookdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "content")
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "header")
    private String header;

    @Column(name = "body", length = 5000)
    private String body;
}
