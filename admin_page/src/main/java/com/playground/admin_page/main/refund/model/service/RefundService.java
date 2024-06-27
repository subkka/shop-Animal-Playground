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

    /**
     * 환불 목록 조회
     */
    public List<RefundDto> findRefundList() {
        return refundMapper.findRefundList();
    }

    /**
     * 환불 목록 상세 조회
     */
    public RefundDto findRefundDetailList(Long id) {
        return refundMapper.findRefundDetailList(id);
    }

    /**
     * 환불 목록 상세 페이지에서 수정 눌렀을 때
     * 1. 환불 상품 철회 완료 여부 확인
     * 2. 처리 상태가 처리완료일 때, 환불 상품 철회 완료 되었다고 처리
     * 3. 처리 상태 업데이트 처리
     * 4. 철회 완료된 상품 정보 저장
     */
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class

    )
    public int updateProcessStatus(Long refundId, Long orderId, String refundYn, String processStatus) {
        // 철회 여부 확인
        String prodReturnVal = refundMapper.checkProdReturnStatus(orderId);
        if(prodReturnVal.equals("Y")) { // 철회 완료 시
            if(processStatus.equals("처리중")) { // 철회도 완료하였고 처리상태가 처리중일 때
                processStatus = "처리완료";
            }
        }else {
            // 처리완료로 수정하였을 때
            if(processStatus.equals("처리완료")) {
                refundMapper.updateProdReturnStatus(orderId); // 철회 여부 완료로 수정
            }
        }

        int result = refundMapper.updateProcessStatus(orderId, refundYn, processStatus);

        // 철회 완료 상품 정보 저장
        int refundData = refundMapper.searchRefundData(orderId);
        if(refundData == 0) {
            List<RefundProductDto> refundProductDtos = refundMapper.findProductForRefund(orderId);
            for(RefundProductDto refundProductDto : refundProductDtos) {
                refundProductDto.setRefundId(refundId);
            }
            refundMapper.insertRefundProduct(refundProductDtos);
        }

        return result;
    }
}
