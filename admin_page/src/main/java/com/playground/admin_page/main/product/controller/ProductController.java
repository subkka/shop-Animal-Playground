package com.playground.admin_page.main.product.controller;

import com.playground.admin_page.main.product.dto.ProductDto;
import com.playground.admin_page.main.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public String list(Model model) {
        log.info("GET /product/list");
        List<ProductDto> products = productService.findAll();
        log.debug("products ={}", products);
        model.addAttribute("products", products);
        return "/product/list";
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
    public String edit(@ModelAttribute ProductDto product, @RequestParam("imageFile") MultipartFile file) {
        log.info("Received edit request. Product: {}, File: {}", product, (file != null ? file.getOriginalFilename() : "No file"));
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = saveImage(file);
                if (fileName != null) {
                    product.setProductImage(fileName);
                }
            } catch (IOException e) {
                log.error("Error saving image file", e);
            }
        }
        productService.updateProduct(product);
        return "redirect:/product/detail/" + product.getProductId();
    }
    @GetMapping("/create")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new ProductDto());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto product, @RequestParam("imageFile") MultipartFile file) {
        log.info("Received edit request. Product: {}, File: {}", product, (file != null ? file.getOriginalFilename() : "No file"));
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = saveImage(file);
                if (fileName != null) {
                    product.setProductImage(fileName);
                }
            } catch (IOException e) {
                log.error("Error saving image file", e);
            }
        }
        productService.createProduct(product);
        return "redirect:/product/list";
    }
    private String saveImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadPath = Paths.get("admin_page/src/main/resources/static/img/uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return "/img/uploads/" + fileName;  // 반환 경로 수정
        } catch (IOException e) {
            throw new IOException("Could not save image file: " + fileName, e);
        }
    }
}
