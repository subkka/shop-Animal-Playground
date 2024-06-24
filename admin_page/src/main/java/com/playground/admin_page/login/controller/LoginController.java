package com.playground.admin_page.login.controller;

import com.playground.admin_page.login.model.dto.AdminDto;
import com.playground.admin_page.login.model.service.LoginQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes({"name"})
public class LoginController {
    private final LoginQueryService loginQueryService;

    @PostMapping("/login")
    public String login(Model model, @RequestParam String id, @RequestParam String password) {
        log.info("POST /member/login");
        log.debug("id/password = {}/{}", id, password);

        AdminDto adminDto = loginQueryService.findByLoginInfo(id, password); // 로그인 정보 불러오기
        log.debug("memberDto = {}", adminDto);
        model.addAttribute("name", adminDto.getName()); // 사용자 이름 세션에 저장
        return "redirect:/"; // 인덱스 페이지로 리다이렉트
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        log.info("Get /member/logout");

        sessionStatus.setComplete(); // 세션 폐기
        return "redirect:/";
    }

    @GetMapping("/adminOnly")
    public String adminOnly(Model model) {
        log.info("GET /member/membersOnly");
        return "/admin/adminOnly";
    }
}