package com.playground.admin_page.main.product.service;

import com.playground.admin_page.main.product.dao.ProductMapper;
import com.playground.admin_page.main.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    public List<ProductDto> findAll() {
        return productMapper.findAll();
    }

    public ProductDto findByProductId(int productId) {
        return productMapper.findByProductId(productId);
    }

    public int createProduct(ProductDto product) {
        return productMapper.createProduct(product);
    }
}
