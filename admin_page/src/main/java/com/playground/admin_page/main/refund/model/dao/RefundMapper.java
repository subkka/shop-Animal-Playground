package com.playground.admin_page.main.refund.model.dao;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import com.playground.admin_page.main.refund.model.dto.RefundProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RefundMapper {
    List<RefundDto> findRefundList();

    RefundDto findRefundDetailList(Long id);

    int updateProcessStatus(@Param("orderId") Long orderId, @Param("refundYn") String refundYn, @Param("processStatus") String processStatus);

    int insertRefundProduct(List<RefundProductDto> refundProductList);

    List<RefundProductDto> findProductForRefund(Long orderId);
}
