package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ProductDTO;
import com.kirky.lookbookdemo.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    ProductDTO getProductById(Integer id);
    ProductDTO addProduct(ProductDTO productDTO);
    Product deleteProductById(Integer id);
}
