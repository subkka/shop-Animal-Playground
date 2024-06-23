package com.playground.admin_page.main.product.controller;

import com.playground.admin_page.main.product.dto.ProductDto;
import com.playground.admin_page.main.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /product/list");
        List<ProductDto> products = productService.findAll();
        log.debug("products ={}", products);
        model.addAttribute("products", products);
    }
}
