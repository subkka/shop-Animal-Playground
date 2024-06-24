package com.playground.admin_page.auth.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/check-login-status")
    public Map<String, Boolean> checkLoginStatus(HttpSession session) {
        log.info("GET /auth/check-login-status");

        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        Map<String, Boolean> response = new HashMap<>();
        response.put("loggedIn", loggedIn != null && loggedIn);

        return response;
    }
}
