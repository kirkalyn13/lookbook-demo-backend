package com.kirky.lookbookdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String title;
    private String description;
    private String thumbnail;
}
