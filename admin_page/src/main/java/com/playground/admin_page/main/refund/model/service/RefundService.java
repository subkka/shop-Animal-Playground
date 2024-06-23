package com.playground.admin_page.main.refund.model.service;

import com.playground.admin_page.main.refund.model.dao.RefundMapper;
import com.playground.admin_page.main.refund.model.dto.RefundDto;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefundService {
    private final RefundMapper refundMapper;
    public List<RefundDto> findRefundList() {
        return refundMapper.findRefundList();
    }
}
