package com.playground.admin_page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/main")
    public String getMain(Model model) {
        return "main";
    }

    @GetMapping("/tables")
    public String sampleTables(Model model) {
        return "tables";
    }

    @GetMapping("/charts")
    public String sampleCharts() {
        return "charts";
    }
}
