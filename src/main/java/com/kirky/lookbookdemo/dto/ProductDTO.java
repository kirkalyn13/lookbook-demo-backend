package com.kirky.lookbookdemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ProductDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String thumbnail;
}
