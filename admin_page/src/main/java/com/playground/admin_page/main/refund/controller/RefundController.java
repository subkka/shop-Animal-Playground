package com.playground.admin_page.main.refund.controller;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.service.RefundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RefundController {
    private final RefundService refundService;

    @GetMapping("/refundList")
    public String refundList(Model model) {
        log.info("GET refundList");
        List<RefundDto> refundList = refundService.findRefundList();
        log.debug("refundList = {}", refundList);
        model.addAttribute("refundList", refundList);
        return "refundList";
    }
}
