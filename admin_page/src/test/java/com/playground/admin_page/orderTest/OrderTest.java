//package com.playground.admin_page.orderTest;
//
//import com.playground.admin_page.main.order.dao.OrderMapper;
//import com.playground.admin_page.main.order.dto.order.*;
//import com.playground.admin_page.main.refund.model.dao.RefundMapper;
//import com.playground.admin_page.main.refund.model.dto.RefundDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class OrderTest {
//
//    private RefundMapper refundMapper;
//    private  OrderMapper ordermapper;
//
//    public OrderTest(OrderMapper ordermapper) {
//        this.ordermapper = ordermapper;
//    }
//
//
//    public OrderTest(RefundMapper refundMapper) {
//        this.refundMapper = refundMapper;
//    }
//    @Test
//    @DisplayName("모든 주문 내역 조회 ")
//    void test1() {
//        //given
//        List<OrderDto> orders = ordermapper.findAllOrder();
//        System.out.println(orders);
//        //then
//        assertThat(orders).isNotNull().allMatch(m -> m != null);
//
//        //when
//        //then
//    }
//
//    @Test
//    @DisplayName("상태별 주문 조회")
//    void test2() {
//        //given
//        String status = "PENDING";
//
//        //when
//        List<OrderDto> orders = ordermapper.findByStatus(status);
//        System.out.println(orders);
//        //then
//        assertThat(orders).isNotNull().allMatch(m -> m != null);
//
//    }
//
//    @Test
//    @DisplayName("제품 상세정보 출력하기 ")
//    void test4() {
//        //given
//        int orderId = 1;
//        //when
//        OrderDetailDto orders = ordermapper.productDetail(orderId);
//        System.out.println(orders);
//        //then
//
//        //assertThat(orders).isNotNull().allMatch(m -> m != null);
//    }
//
//    @Test
//    @DisplayName("제품 재고 확인하기")
//    void test5() {
//        //given
//        // 재고를 확인하려면 일단 -> 주문 상태가 order_status 인거 가져오고 , 거기서
//        int orderId = 1;
//        List<OrderDetailDto> orders = ordermapper.stockCheck(orderId);
//
//        //when
//        //then
//    }
//
//    @Test
//    @DisplayName("취소 상태 변경하기 ")
//    void test6() {
//        //given
//        int orderId = 1;
//        //when
//        int result = ordermapper.statusChange(orderId);
//        //then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("취소 테이블에 삽입하기")
//    void test7() {
//        //given
//        int orderId = 1;
//        //when
//        int result = ordermapper.insertCancel(orderId);
//
//        Assertions.assertThat(result).isEqualTo(1);
//
//        //then
//
//    }
//
//    @Test
//    @DisplayName("주문번호로 주문 정보 출력 ")
//    void test8() {
//        //given
//        int orderId = 1;
//        OrderDto orderDto = ordermapper.findByOrderId(orderId);
//        System.out.println(orderDto);
//        //when
//        Assertions.assertThat(orderDto).isNotNull();
//        //then
//
//    }
//
//    @Test
//    @DisplayName("주문 취소된 정보 확인")
//    void test9() {
//        //given
//        List<CancelDto> cancel = ordermapper.cancelInformation();
//        //when
//        Assertions.assertThat(cancel).isNotNull();
//        //then
//    }
//
//    @Test
//    @DisplayName("총 매출 조회하기")
//    void test10() {
//        //given 692000
//        int sales = ordermapper.getSales();
//        //when
//        Assertions.assertThat(sales).isEqualTo(692000);
//        //then
//    }
//
//    @Test
//    @DisplayName("")
//    void test11() {
//        //given
//        int result = ordermapper.getOrderCount();
//        //when
//        Assertions.assertThat(result).isEqualTo(16);
//        //then
//    }
//
//
//
//    @Test
//    @DisplayName("상태 주문 완료인거 조회")
//    void test12() {
//        //given
//        List<OrderDetailDto> list = ordermapper.findComplete();
//        System.out.println(list);
//
//        Assertions.assertThat(list).isNotNull();
//    }
//
//
//
//    @Test
//    @DisplayName("카테고리 종류 출력")
//    void test13() {
//        //given
//        //when
//        List<String> categoryList = ordermapper.getCategoryList();
//        System.out.println(categoryList);
//        //then
//        Assertions.assertThat(categoryList).isNotNull();
//
//    }
//
//    @Test
//    @DisplayName("카테고리별 판매 수")
//    void test14 () {
//        //given
//        //when
//        List<Integer> countByCategory = ordermapper.getCountByCategory();
//        //then
//    }
//
//    @Test
//    @DisplayName("주문 상태 조회하기 ")
//    void test15() {
//        //given
//        //when
//        List<String> getKindStatus = ordermapper.getKindStatus();
//        System.out.println(getKindStatus);
//        //then
//        Assertions.assertThat(getKindStatus).isNotNull();
//    }
//
//    @Test
//    @DisplayName("주문 상태 가져오기")
//    void test16() {
//        //given
//        //when
//        List<Integer> getCountStatus = ordermapper.getCountStatus();
//        System.out.println(getCountStatus);
//        //then
//        Assertions.assertThat(getCountStatus).isNotNull();
//    }
//
////    @Test
////    @DisplayName("환불 가져오기")
////    void test17() {
////        //given
////        //when
////        List<String> listName = ordermapper.getKindStatus();
////        String name = "REFUND";
////        listName.add(name);
////        Collections.sort(listName);
////
////        List<RefundDto> refundList = refundMapper.findRefundList();
////        int size = refundList.size();
////
////        List<Integer> listCount = ordermapper.getCountStatus();
////        listCount.add(size);
////
////        for (String itemName : listName) {
////            System.out.println(itemName);
////        }
////
////        for (int a : listCount) {
////            System.out.println(
////           a );
////        }
////
////        //then
////
////    }
//
//    @Test
//    @DisplayName("년도별 매출 누적합 구하기")
//    void test20() {
//        //given
//        List<SumByYearDto> list = ordermapper.sumByYear();
//        System.out.println(list);
//        //when
//        //then
//        Assertions.assertThat(list).isNotNull();
//    }
//
//
//
//}