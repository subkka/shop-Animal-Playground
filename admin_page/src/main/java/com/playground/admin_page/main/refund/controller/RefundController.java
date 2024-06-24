package com.playground.admin_page.main.refund.controller;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.service.RefundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RefundController {
    private final RefundService refundService;

    //
    @GetMapping("/refundList")
    public String refundList(Model model) {
        log.info("GET refundList");
        List<RefundDto> refundList = refundService.findRefundList();
        log.debug("refundList = {}", refundList);
        model.addAttribute("refundList", refundList);
        return "refundList";
    }

    @GetMapping("/refundDetailList/{orderId}")
    public String refundDetailList(@PathVariable("orderId") Long id, Model model) {
        log.info("GET refundDetailList");
        RefundDto refundDetailList = refundService.findRefundDetailList(id);
        log.debug("refundDetailList = {}", refundDetailList);
        model.addAttribute("refundDetailList", refundDetailList);
        return "refundDetailList";
    }

    @PostMapping("/updateProcessStatus/{orderId}")
    public String updateProcessStatus(@PathVariable("orderId") Long id, @RequestParam String processStatus, RedirectAttributes redirectAttributes) {
        log.info("POST updateProcessStatus");
        int refundDetailList = refundService.updateProcessStatus(id, processStatus);
        redirectAttributes.addFlashAttribute("updateResult", refundDetailList > 0 ? "처리 상태가 변경되었습니다." : "처리 상태 변경을 실패했습니다. 다시 시도해주세요.");
        return "redirect:/refundDetailList";
    }
}
