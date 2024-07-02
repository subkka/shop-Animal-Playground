package com.playground.admin_page;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ServletComponentScan
@MapperScan
public class AdminPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPageApplication.class, args);
    }
}
