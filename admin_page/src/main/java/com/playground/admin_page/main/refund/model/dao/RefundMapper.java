package com.playground.admin_page.main.refund.model.dao;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.dto.RefundProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RefundMapper {
    // 환불 목록 조회
    List<RefundDto> findRefundList();

    // 환불 목록 상세 조회
    RefundDto findRefundDetailList(Long id);

    // 처리 상태 수정
    int updateProcessStatus(@Param("orderId") Long orderId, @Param("refundYn") String refundYn, @Param("processStatus") String processStatus);

    // 철회 완료 상품 정보 저장
    int insertRefundProduct(List<RefundProductDto> refundProductList);

    // 철회된 상품 정보 조회
    List<RefundProductDto> findProductForRefund(Long orderId);

    // 철회 여부 확인
    String checkProdReturnStatus(Long orderId);

    // 철회 여부 완료로 수정
    int updateProdReturnStatus(Long orderId);

    int searchRefundData(Long orderId);
}
