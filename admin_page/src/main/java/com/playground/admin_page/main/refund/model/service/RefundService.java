package com.playground.admin_page.main.refund.model.service;

import com.playground.admin_page.main.refund.model.dao.RefundMapper;
import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.dto.RefundProductDto;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefundService {
    private final RefundMapper refundMapper;

    // 환불 목록 조회
    public List<RefundDto> findRefundList() {
        return refundMapper.findRefundList();
    }

    // 환불 상세 목록 조회
    public RefundDto findRefundDetailList(Long id) {
        return refundMapper.findRefundDetailList(id);
    }

    // 환불 처리 상태 수정 및 환불된 상품들 추가
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class
    )
    public int updateProcessStatus(Long orderId, String refundYn, String processStatus) {
        // 처리 상태 업데이트
        String prodReturnVal = refundMapper.checkProdReturnStatus(orderId);
        if(prodReturnVal.equals("Y")) {
            if(!processStatus.equals("처리대기")) {
                processStatus = "처리완료";
            }
        }

        if(processStatus.equals("처리완료")) {
            refundMapper.updateProdReturnStatus(orderId);
        }
        if (refundMapper.updateProcessStatus(orderId, refundYn, processStatus) != 1) {
            throw new RuntimeException("처리 상태 업데이트 실패");
        }

        // 환불 상품 저장
        List<RefundProductDto> productForRefund = refundMapper.findProductForRefund(orderId);
        int result = insertRefundProduct(productForRefund);
        if(result <= 0) {
            throw new RuntimeException("환불 상품 저장 실패");
        }
        return result;
    }

    public int insertRefundProduct(List<RefundProductDto> refundProductList) {
        return refundMapper.insertRefundProduct(refundProductList);
    }

    public int updateComplete(Long orderId, String processStatus) {
        return refundMapper.updateComplete(orderId, processStatus);
    }
}
