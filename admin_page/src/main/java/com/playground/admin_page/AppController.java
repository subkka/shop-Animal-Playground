package com.playground.admin_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
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
