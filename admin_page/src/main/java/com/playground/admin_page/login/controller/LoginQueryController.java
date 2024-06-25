package com.playground.admin_page.login.controller;

import com.playground.admin_page.login.model.dto.AdminAccountDto;
import com.playground.admin_page.login.model.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
@SessionAttributes({"adminAccount"})
public class LoginQueryController {
    private final LoginService loginService;

    @GetMapping(produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String login(Model model, @RequestParam String id, @RequestParam String password) {
        log.info("GET /login");
        log.debug("id/pwd: {}/{}", id, password);

        // 로그인 정보로 쿼리 조회
        AdminAccountDto adminAccountDto = loginService.findByLoginInfo(id, password);
        log.debug("memberDto = {}", adminAccountDto);

        if (adminAccountDto != null) { // 아이디 패스워드가 일치하는 경우
            // session에 저장
            model.addAttribute("adminAccount", adminAccountDto);
            // main 화면으로 이동
            return "success";
        } else {
            return "fail";
        }
    }
}
