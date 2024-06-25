package com.playground.admin_page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Slf4j
@SessionAttributes({"adminAccount"})
public class SampleController {
    @GetMapping()
    public String index() {
        return "index";
    }

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
