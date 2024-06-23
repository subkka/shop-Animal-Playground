package com.playground.admin_page.main.refund.model.service;

import com.playground.admin_page.main.refund.model.dao.RefundMapper;
import com.playground.admin_page.main.refund.model.dto.RefundDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefundServiceTest {
    @Autowired
    private RefundMapper refundMapper;

    @Test
    @DisplayName("환불 목록 조회")
    void test1() {
        // given
        // when
        List<RefundDto> refundList = refundMapper.findRefundList();
        System.out.println(refundList);
        // then
        assertThat(refundList)
                .isNotNull()
                .isNotEmpty();
    }
}