package com.playground.admin_page.main.refund.controller;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.service.RefundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/refund")
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
        return "refund/refundList";
    }

    @GetMapping("/refundDetailList/{refundId}")
    public String refundDetailList(@PathVariable("refundId") Long id, Model model) {
        log.info("GET refundDetailList");
        RefundDto refundDetailList = refundService.findRefundDetailList(id);
        log.debug("refundDetailList = {}", refundDetailList);
        model.addAttribute("refundDetailList", refundDetailList);
        return "refund/refundDetailList";
    }

    @GetMapping("/updatePage/{refundId}")
    public String goToUpdatePage(@PathVariable("refundId") Long id, Model model) {
        log.info("GET goToUpdatePage");
        log.debug("id = {}",id);
        RefundDto refundDetailList = refundService.findRefundDetailList(id);
        model.addAttribute("refundDetailList", refundDetailList);
        return "refund/update";
    }

    @PostMapping("/update")
    public String updateProcessStatus(@RequestParam("orderId") Long orderId, @RequestParam(required = false) String refundYn, @RequestParam String processStatus, RedirectAttributes redirectAttributes) {
        log.info("POST updateProcessStatus");
        log.debug("orderId = {}", orderId);
        log.debug("refundYn = {}", refundYn);
        log.debug("processStatus = {}", processStatus);
        if (refundYn != null && refundYn.isEmpty()) {
            refundYn = null;
        }
        int refundDetailList = refundService.updateProcessStatus(orderId, refundYn, processStatus);
        redirectAttributes.addFlashAttribute("updateResult", refundDetailList > 0 ? "처리 상태가 변경되었습니다." : "처리 상태 변경을 실패했습니다. 다시 시도해주세요.");
        return "redirect:/refund/refundDetailList/" + orderId;
    }

//    @PostMapping("/update")
//    public String updateProcessStatus(@RequestParam Long orderId, @RequestParam String refundYn, @RequestParam String processStatus) {
//        log.info("POST updateProcessStatus");
//        log.debug("orderId = {}", orderId);
//        log.debug("refundYn = {}", refundYn);
//        log.debug("processStatus = {}", processStatus);
//        return "redirect:/refund/refundDetailList/" + orderId;
//    }
}
