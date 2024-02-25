package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ProductDTO;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    PageImpl<ProductDTO> getProductsPaginated(Pageable pageable);
    ProductDTO getProductById(Integer id);
    ProductDTO addProduct(ProductDTO productDTO);
    void deleteProductById(Integer id);
}
