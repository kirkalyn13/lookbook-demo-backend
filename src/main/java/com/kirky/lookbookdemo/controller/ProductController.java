package com.kirky.lookbookdemo.controller;

import com.kirky.lookbookdemo.dto.ProductDTO;
import com.kirky.lookbookdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products") // Using plural to be in sync with dummyjson endpoint
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> results = productService.getProducts();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{id:.+}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) {
        ProductDTO result = productService.getProductById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO result = productService.addProduct(productDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id:.+}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
