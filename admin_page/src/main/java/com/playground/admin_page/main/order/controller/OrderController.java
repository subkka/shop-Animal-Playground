package com.playground.admin_page.main.order.controller;

import com.playground.admin_page.main.order.dto.order.OrderDto;
import com.playground.admin_page.main.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/findAllOrder")
    public String findAllOrder(Model model) {
        List<OrderDto> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "order/findAllOrder"; // 템플릿 파일 이름을 반환합니다.
    }

}