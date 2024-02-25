package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    Page<ProductDTO> getProductsPaginated(Pageable pageable);
    ProductDTO getProductById(Integer id);
    ProductDTO addProduct(ProductDTO productDTO);
    void deleteProductById(Integer id);
}
