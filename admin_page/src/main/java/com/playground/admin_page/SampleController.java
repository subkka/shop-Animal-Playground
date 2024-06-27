package com.playground.admin_page;

import com.playground.admin_page.main.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SampleController {

    private final OrderService orderService;
    @GetMapping("/main")
    public String getMain(Model model) {
        List<String> getKindStatus = orderService.getKindStaus();
        List<Integer> getCountStatus = orderService.getCountStatus();
        model.addAttribute("getKindStatus", getKindStatus);
        model.addAttribute("getCountStatus", getCountStatus);
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
