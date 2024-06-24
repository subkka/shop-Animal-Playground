package com.playground.admin_page;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class AdminPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPageApplication.class, args);
    }

}
