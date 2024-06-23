package com.playground.admin_page.main.product.controller;

import com.playground.admin_page.main.product.dto.ProductDto;
import com.playground.admin_page.main.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        log.info("GET /product/detail/{}", id);
        ProductDto product = productService.findByProductId(id);
        model.addAttribute("product", product);
        return "product/detail";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute ProductDto productDto) {
        log.info("POST /product/edit");
        productService.updateProduct(productDto);
        return "redirect:/product/detail/" + productDto.getProductId();
    }
}
