package com.playground.admin_page.main.user.controller;
import com.playground.admin_page.main.user.model.dto.UserDto;
import com.playground.admin_page.main.user.model.dto.UserEmailAble;
import com.playground.admin_page.main.user.model.dto.UserPet;
import com.playground.admin_page.main.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private List<String> userNames;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("Get /user/list");

        List<UserDto> users = userService.findAll();
        log.debug("users = {}", users);
        searchSetUp(users); // 검색시 사용하기 위한 사용자 정보 저장

        model.addAttribute("users", users);
        return "user/list";
    }

    private void searchSetUp(List<UserDto> users) {
        // 사용자 이름 리스트 저장
        userNames = new ArrayList<>(); // 초기화
        for (UserDto user : users) {
            userNames.add(user.getUserName());
        }
    }

    @GetMapping(path = "/searchByUsername", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<String> searchByUsername(@RequestParam String searchValue) {
        log.info("GET /user/searchByUsername");
        log.debug("searchValue: {}", searchValue);

        return userNames.stream()
                .filter((name) -> name.contains(searchValue))
                .toList();
    }


//    사용 불가

    @GetMapping("/findById")
    public String findById(@RequestParam("userId") Long userId, Model model) {
        log.info("Get /user/findById");
        List<UserDto> users = userService.findById(userId);
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "user/searchList";
    }

    @GetMapping("/findByPet")
    public String findByPet(@RequestParam("userPet") UserPet userPet, Model model) {
        log.info("Get /user/findByPet");
        List<UserDto> users = userService.findByPet(userPet);
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "list/searchList";
    }

    @GetMapping("/findByEmailAble")
    public String findByEmailAbleStatus(@RequestParam("userEmailAble") UserEmailAble userEmailAble, Model model) {
        log.info("Get /user/findByEmailAbleStatus");
        List<UserDto> users = userService.findByEmailAble(userEmailAble);
        log.debug("users = {}", users);
        model.addAttribute("users", users);
        return "user/sendEmail";
    }

    @GetMapping("/setDormantUsers")
    public String setDormantUsers() {
        userService.setDormant();
        return "redirect:/user/list";
    }
}