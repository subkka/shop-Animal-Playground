package com.playground.admin_page;

import com.playground.admin_page.main.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AppController {
    private final OrderService orderService;

    @GetMapping("")
    public String index(HttpServletRequest request) {
        log.info("GET /index");
        HttpSession session = request.getSession(); // 비동기를 위한 Session 객체 생성
        return "index";
    }

    @GetMapping("/main")
    public String getMain(Model model) {
        List<String> getKindStatus = orderService.getKindStaus();
        List<Integer> getCountStatus = orderService.getCountStatus();
        model.addAttribute("getKindStatus", getKindStatus);
        model.addAttribute("getCountStatus", getCountStatus);
        return "main";
    }

    // 접근 제한 페이지
    @GetMapping("/access-limit")
    public String acessLimit() {
        return "access-limit";
    }
}
