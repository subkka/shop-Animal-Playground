package com.playground.admin_page.main.user.controller;

import com.playground.admin_page.main.user.model.dto.UserDto;
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

    @GetMapping(path = "/get-username-list", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<String> getUsernameList(@RequestParam String searchValue) {
        log.info("GET /user/get-username-list");
        log.debug("searchValue: {}", searchValue);

        return userNames.stream()
                .filter((name) -> name.contains(searchValue))
                .toList();
    }

    @GetMapping(path = "/search-by-username", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<UserDto> searchByUsername(@RequestParam String username) {
        log.info("GET /user/search-by-username");
        log.debug("searchValue: {}", username);

        return userService.findByUsername(username);
    }

    @GetMapping(path = "/search-by-pet", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<UserDto> searchByPet(@RequestParam String selectedPet) {
        log.info("GET /user/search-by-pet");
        log.debug("selectedPet: {}", selectedPet);

        return switch (selectedPet) {
            case "All" -> userService.findAll();
            case "Dog" -> userService.findByPet(UserPet.Dog);
            case "Cat" -> userService.findByPet(UserPet.Cat);
            default -> null;
        };
    }
}