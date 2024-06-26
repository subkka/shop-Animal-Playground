//package com.playground.admin_page.main.dashboard;
//
//import com.playground.admin_page.main.product.dto.ProductDto;
//import com.playground.admin_page.main.product.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@Slf4j
//
//@RequiredArgsConstructor
//public class DashboardController {
//    private final ProductService productService;
//    @GetMapping("/main")
//    public String productList(Model model) {
//        log.info("GET /main");
//        List<ProductDto> products = productService.findAll();
////        log.debug("products = {}", products);
//
//        model.addAttribute("products", products);
//        return "/main";
//    }
//}
