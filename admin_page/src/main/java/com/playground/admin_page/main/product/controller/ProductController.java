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
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        log.info("GET /product/edit/{}", id);
        ProductDto product = productService.findByProductId(id);
        model.addAttribute("product", product);
        return "product/edit";  // edit.html 템플릿을 사용
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute ProductDto product) {
        log.info("POST /product/edit");
        productService.updateProduct(product);
        return "redirect:/product/detail/" + product.getProductId();
    }
    @GetMapping("/create")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductDto());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto productDto) {
        log.info("Adding new product: {}", productDto);
        productService.createProduct(productDto);
        return "redirect:/product/list";
    }
}
