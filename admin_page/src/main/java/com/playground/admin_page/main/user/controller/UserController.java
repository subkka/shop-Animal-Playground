package com.playground.admin_page.main.user.controller;
import com.playground.admin_page.main.user.model.dto.InfoDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import com.playground.admin_page.main.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/list")
    public String list(Model model) {
        log.info("Get /user/list");
        List<InfoDto> users = userService.findAll();
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam("userNo") Long userNo, Model model) {
        log.info("Get /user/findById");
        List<InfoDto> users = userService.findById(userNo);
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/findByPet")
    public String findByPet(@RequestParam("userPet") UserPet userPet, Model model) {
        log.info("Get /user/findByPet");
        List<InfoDto> users = userService.findByPet(userPet);
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "list";
    }


    @GetMapping("/findByEmailAble")
    public String findByEmailAbleStatus(@RequestParam("userEmailAble") String userEmailAble, Model model) {
        log.info("Get /user/findByEmailAbleStatus");
        List<InfoDto> users = userService.findByEmailAble();
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "list";
    }
    @GetMapping("/setDormantUsers")
    public String setDormantUsers() {
        userService.setDormant();
        return "redirect:/user/list";
    }
}


