//package com.playground.admin_page.main.refund.model.service;
//
//import com.playground.admin_page.main.refund.model.dao.RefundMapper;
//import com.playground.admin_page.main.refund.model.dto.RefundDto;
//import com.playground.admin_page.main.refund.model.dto.RefundProductDto;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class RefundServiceTest {
//    @Autowired
//    private RefundMapper refundMapper;
//
//    @Test
//    @DisplayName("환불 목록 조회")
//    void findRefundList() {
//        // given
//        // when
//        List<RefundDto> refundList = refundMapper.findRefundList();
//        System.out.println(refundList);
//        // then
//        assertThat(refundList)
//                .isNotNull()
//                .isNotEmpty();
//    }
//
//    @Test
//    @DisplayName("환불 상세 목록 조회")
//    void findRefundDetailList() {
//        // given
//        Long id = 1L;
//        // when
//        RefundDto refundDetailList = refundMapper.findRefundDetailList(id);
//        System.out.println(refundDetailList);
//        // then
//        assertThat(refundDetailList)
//                .isNotNull();
//    }
//
//    @Test
//    @DisplayName("처리 상태 업데이트")
//    void updateProcessStatus() {
//        // given
//        Long id = 1L;
//        String processStatus = "처리완료";
//        // when
//        int result = refundMapper.updateProcessStatus(id, processStatus, processStatus);
//        System.out.println(result);
//        // then
//        assertThat(result)
//                .isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("환불 상품 저장")
//    void insertRefundProduct() {
//        // given
//        // 주문 번호와 일치하는 주문 상품 번호들을 List<RefundProductDto> 생성자를 통해 넣기
//        List<RefundProductDto> refundProductList = new ArrayList<>();
//
//        int orderProductId = 1;
//        Long refundId = 1L;
//
//        RefundProductDto refundProduct = new RefundProductDto(null, orderProductId, refundId);
//        refundProductList.add(refundProduct);
//        orderProductId = 2;
//        refundId = 1L;
//
//        refundProduct = new RefundProductDto(null, orderProductId, refundId);
//        refundProductList.add(refundProduct);
//        System.out.println(refundProductList);
//        // when
//        int result = refundMapper.insertRefundProduct(refundProductList);
//        System.out.println(result);
//        // then
////        assertThat(result)
////                .isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("환불 상품 목록 찾기")
//    void findProductForRefund() {
//        // given
//        // 주문 번호와 일치하는 주문 상품 번호들을 List<RefundProductDto> 생성자를 통해 넣기
//        Long id = 3L;
//        // when
//        List<RefundProductDto> productForRefund = refundMapper.findProductForRefund(id);
//        System.out.println(productForRefund);
//        // then
////        assertThat(result)
////                .isEqualTo(1);
//    }
//
//}