package com.playground.admin_page.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
//@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public void login() {
        log.info("GET /login");
    }
}
