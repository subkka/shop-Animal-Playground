package com.playground.admin_page.main.order.controller;

import com.playground.admin_page.main.order.dto.order.*;
import com.playground.admin_page.main.order.service.OrderService;
import com.playground.admin_page.main.refund.model.service.RefundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final RefundService refundService;

    @GetMapping("/findAllOrder")
    public String findAllOrder(Model model) {
        List<OrderDto> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "/order/findAllOrder";
    }

    @GetMapping("/detail/{id}")
    public String getOrderDetail(@PathVariable int id, Model model) {
//        List<OrderDetailDto> details = orderService.getOrderDetail(id);
        OrderDetailDto detail = orderService.productDetail(id);
        model.addAttribute("detail", detail);
        return "/order/detail";
    }

    //상태별 주문조회
    @GetMapping("/listByStatus")
    public String findByStatus(@RequestParam(name = "status", required = false) String status, Model model) {
        List<OrderDto> orders;
        if (status == "") {
            orders = orderService.findAllOrder();
            model.addAttribute("orders", orders);
            return "/order/findAllOrder";
        } else {
            orders = orderService.findByStatus(status);
            model.addAttribute("orders", orders);
            System.out.println(orders);

            return "/order/findByStatus";
        }

    }

    @GetMapping("/informationProduct/{id}")
    public String informationProduct(@PathVariable int id, Model model) {
        OrderDetailDto orderDetailDto = orderService.informationProductDetail(id);
        model.addAttribute("orderDetailDto", orderDetailDto);
        return "/order/informationProduct";
    }

    @GetMapping("/orderCancel/{orderId}")
    public String orderCancel(@PathVariable int orderId) {
        orderService.statusChange(orderId);
        orderService.insertCancel(orderId);
        return "redirect:/order/findAllOrder";
    }


    @GetMapping("/cancelInformation")
    public String CancelInformation(Model model) {
        List<CancelDto> cancels = orderService.cancelInformation();
        log.debug("{}", cancels);
        model.addAttribute("cancels", cancels);
        return "/order/cancelInformation";
    }

    @GetMapping("/sales")
    public String getSales(Model model) {
        int count = orderService.getOrderCount();
        int sales = orderService.getSales();
        SalesDto salesDto = new SalesDto(count, sales);
        model.addAttribute("salesDto", salesDto);
        return "/order/sales";
    }

//    @GetMapping("/findComplete")
//    public String findComplete(Model model) {
//        int count = orderService.getOrderCount();
//        int sales = orderService.getSales();
//        SalesDto salesDto = new SalesDto(count, sales);
//        model.addAttribute("salesDto", salesDto);
//
//        List<String> categoryList = orderService.getCategoryList();
//        List<Integer> getCountCategory = orderService.getCountByCategory();
//        List<String> petLIst = orderService.getPetList();
//        List<Integer> getCountUserPet = orderService.getCountByUserPet();
//
//        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("getCount", getCountCategory);
//        model.addAttribute("categoryList2", petLIst);
//        model.addAttribute("getCount2", getCountUserPet);
//
//
//        List<OrderDetailDto> orderDetailDtos = orderService.findComplete();
//        model.addAttribute("orderDetailDtos", orderDetailDtos);
//        return "/order/findComplete";
//    }

    @GetMapping("/findComplete")
    public String findComplete(Model model) {
        int count = orderService.getOrderCount();
        int sales = orderService.getSales();
        SalesDto salesDto = new SalesDto(count, sales);
        model.addAttribute("salesDto", salesDto);

        List<String> categoryList = orderService.getCategoryList();
        List<Integer> getCountCategory = orderService.getCountByCategory();
        List<String> petLIst = orderService.getPetList();
        List<Integer> getCountUserPet = orderService.getCountByUserPet();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("getCount", getCountCategory);
        model.addAttribute("categoryList2", petLIst);
        model.addAttribute("getCount2", getCountUserPet);


        List<OrderDetailDto> orderDetailDtos = orderService.findComplete();
        model.addAttribute("orderDetailDtos", orderDetailDtos);
        return "/order/findComplete";
    }


    @GetMapping("/chart")
    public String index(Model model) {
        List<String> categoryList = orderService.getCategoryList();
        List<Integer> getCountCategory = orderService.getCountByCategory();
        List<String> petLIst = orderService.getPetList();
        List<Integer> getCountUserPet = orderService.getCountByUserPet();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("getCount", getCountCategory);
        model.addAttribute("categoryList2", petLIst);
        model.addAttribute("getCount2", getCountUserPet);

        return "/order/piechart";
    }

    @GetMapping("/totalChart")
    @ResponseBody
    public Map<String, List<Object>> sumByYear() {
        List<SumByYearDto> totalList = orderService.sumByYear();

        List<Object> years = new ArrayList<>();
        List<Object> prices = new ArrayList<>();

        for (SumByYearDto dto : totalList) {
            years.add(dto.getYear());
            prices.add(dto.getTotalPrice());
        }

        Map<String, List<Object>> result = new HashMap<>();
        result.put("year", years);
        result.put("totalPrice", prices);

        return result;
    }
}