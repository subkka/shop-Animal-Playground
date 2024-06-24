package com.playground.admin_page.aspect.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/check-login-status")
    public String checkLoginStatus(Model model) {
        log.info("GET /auth/check-login-status");
        return "login";
    }
}
