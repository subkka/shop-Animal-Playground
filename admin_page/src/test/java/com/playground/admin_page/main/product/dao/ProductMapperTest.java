package com.playground.admin_page.main.product.dao;

import com.playground.admin_page.main.product.dto.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;
    @Test
    @DisplayName("상품 목록 조회")
    void findAll() {
        List<ProductDto> products = productMapper.findAll();
        assertThat(products)
                .isNotNull()
                .isNotEmpty()
                .allMatch((product) -> product != null);
    }

    @DisplayName("상품 상세 조회")
    @Test
    void findByProductId() {
        int prodcutId = 1;
        ProductDto product = productMapper.findByProductId(prodcutId);
        assertThat(product)
                .isNotNull()
                .satisfies(
                        (_product) -> assertThat(_product.getProductId()).isEqualTo(prodcutId),
                        (_product) -> assertThat(_product.getProductName()).isNotNull(),
                        (_product) -> assertThat(_product.getPrice()).isPositive()
                );
        }
}