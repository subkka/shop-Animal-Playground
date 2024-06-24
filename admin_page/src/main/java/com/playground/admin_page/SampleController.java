package com.playground.admin_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/index")
    public String sampleIndex() {
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
}
