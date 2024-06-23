package com.playground.admin_page.main.product.dao;

import com.playground.admin_page.main.product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDto> findAll();

    ProductDto findByProductId(int productId);

    int createProduct(ProductDto product);
}
