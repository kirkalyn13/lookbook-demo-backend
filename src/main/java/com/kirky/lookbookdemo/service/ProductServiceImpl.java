package com.kirky.lookbookdemo.service;

import com.kirky.lookbookdemo.dto.ProductDTO;
import com.kirky.lookbookdemo.model.Product;
import com.kirky.lookbookdemo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .sorted(Comparator.comparing(ProductDTO::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductDTO> getProductsPaginated(String search, Pageable pageable) {
        return productRepository
                .findByTitleContainingIgnoreCase(search, pageable)
                .map(this::convertToDTO);
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No product with id : " + id));
        return convertToDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO addProduct(ProductDTO productDTO) {
        productRepository.save(convertToEntity(productDTO));
        return productDTO;
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository
                .findById(id)
                .map(product -> {
                    productRepository.deleteById(id);
                    return product;
                })
                .orElseThrow(() -> new EntityNotFoundException("No product with id : " + id));
    }

    private ProductDTO convertToDTO(Product entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }
}
