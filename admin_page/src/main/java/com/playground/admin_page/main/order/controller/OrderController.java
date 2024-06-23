package com.playground.admin_page.main.order.controller;

import com.playground.admin_page.main.order.dto.order.OrderDetailDto;
import com.playground.admin_page.main.order.dto.order.OrderDto;
import com.playground.admin_page.main.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/findAllOrder")
    public String findAllOrder(Model model) {
        List<OrderDto> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "/order/findAllOrder";
    }

    @GetMapping("/detail/{id}")
    public String getOrderDetail(@PathVariable int id, Model model) {
//        List<OrderDetailDto> details = orderService.getOrderDetail(id);
        List<OrderDetailDto> details = orderService.productDetail(id);
        model.addAttribute("details", details);
        return "order/detail";
    }

    @GetMapping("/listByStatus")
    public String findByStatus(@RequestParam(name = "status", required = false) String status, Model model) {
        List<OrderDto> orders;
        if(status == ""){
            orders = orderService.findAllOrder();
            model.addAttribute("orders", orders);
            return "/order/findAllOrder";
        }
        else{
            orders = orderService.findByStatus(status);
            model.addAttribute("orders",orders);
            System.out.println(orders);

            return "/order/findByStatus";
        }

    }



//    @GetMapping("/detail/{id}")
//    public String getOrderDetail2(@PathVariable int id, Model model) {
//        List<OrderDetailDto2> details = orderService.productDetail(id);
//        model.addAttribute("details", details);
//        return "order/detail";
//    }
}