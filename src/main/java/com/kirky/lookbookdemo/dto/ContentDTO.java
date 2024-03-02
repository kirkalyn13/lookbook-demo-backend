package com.kirky.lookbookdemo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContentDTO implements Serializable {
    private Integer id;
    private String header;
    private String body;
}
