package com.playground.admin_page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AppController {
    @GetMapping("")
    public String index(HttpServletRequest request) {
        log.info("GET /index");
        HttpSession session = request.getSession(); // 비동기를 위한 Session 객체 생성
        return "index";
    }


    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    // 접근 제한 페이지
    @GetMapping("/access-limit")
    public String acessLimit() {
        return "access-limit";
    }
}
