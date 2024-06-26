package com.playground.admin_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/tables")
    public String sampleTables() {
        return "tables";
    }

    @GetMapping("/charts")
    public String sampleCharts() {
        return "charts";
    }

    // 접근 제한 페이지
    @GetMapping("/access-limit")
    public String acessLimit() {
        return "access-limit";
    }
}
