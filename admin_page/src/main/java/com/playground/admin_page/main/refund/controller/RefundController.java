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

    /**
     * 환불 목록 조회
     */
    @GetMapping("/refundList")
    public String refundList(Model model) {
        log.info("GET refundList");
        List<RefundDto> refundList = refundService.findRefundList();
        log.debug("refundList = {}", refundList);
        model.addAttribute("refundList", refundList);
        return "refund/refundList";
    }

    /**
     * 환불 목록 상세 조회
     */
    @GetMapping("/refundDetailList/{refundId}")
    public String refundDetailList(@PathVariable("refundId") Long id, Model model) {
        log.info("GET refundDetailList");
        RefundDto refundDetailList = refundService.findRefundDetailList(id);
        log.debug("refundDetailList = {}", refundDetailList);
        model.addAttribute("refundDetailList", refundDetailList);
        return "refund/refundDetailList";
    }

    /**
     * 환불 목록 수정 페이지 조회
     */
    @GetMapping("/updatePage/{refundId}")
    public String goToUpdatePage(@PathVariable("refundId") Long id, Model model) {
        log.info("GET goToUpdatePage");
        log.debug("id = {}",id);
        RefundDto refundDetailList = refundService.findRefundDetailList(id);
        model.addAttribute("refundDetailList", refundDetailList);
        return "refund/update";
    }

    /**
     * 환불 목록 상세 페이지에서 수정 눌렀을 때
     * 1. 환불 상품 철회 완료 여부 확인
     * 2. 처리 상태가 처리완료일 때, 환불 상품 철회 완료 되었다고 처리
     * 3. 처리 상태 업데이트 처리
     * 4. 철회 완료된 상품 정보 저장
     */
    @PostMapping("/update")
    public String updateProcessStatus(@RequestParam("refundId") Long refundId, @RequestParam("orderId") Long orderId, @RequestParam(required = false) String refundYn, @RequestParam String processStatus, RedirectAttributes redirectAttributes) {
        log.info("POST updateProcessStatus");
        if (refundYn != null && refundYn.isEmpty()) {
            refundYn = null;
        }
        int updateResult = refundService.updateProcessStatus(orderId, refundYn, processStatus);
        redirectAttributes.addFlashAttribute("updateResult", updateResult > 0 ? "🐕수정되었습니다🐾" : "🐈수정을 실패하였습니다. 다시 시도해주세요🐾");
        return "redirect:/refund/refundDetailList/" + refundId;
    }
}
