package com.playground.admin_page.main.order.service;

import com.playground.admin_page.main.order.dao.OrderMapper;
import com.playground.admin_page.main.order.dto.order.*;
import com.playground.admin_page.main.refund.model.dao.RefundMapper;
import com.playground.admin_page.main.refund.model.dto.RefundDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final RefundMapper refundMapper;

    public List<OrderDto> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    public List<OrderDto> findByStatus(String status) {
        return orderMapper.findByStatus(status);
    }

    public OrderDetailDto productDetail(int orderId) {
        return orderMapper.productDetail(orderId);
    }

    public OrderDetailDto informationProductDetail(int id) {
        return orderMapper.informationProductDetail(id);
    }

    @Transactional
    public void statusChange(int orderId) {
        try {
            int transaction = orderMapper.statusChange(orderId);
            if (transaction != 1) {
                throw new RuntimeException("Transaction failed");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while changing product amount", e);
        }
    }

    @Transactional
    public void insertCancel(int orderId) {
        try {
            int transaction = orderMapper.insertCancel(orderId);
            if (transaction != 1) {
                throw new RuntimeException("Transaction failed");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while changing product amount", e);
        }
    }

    public List<CancelDto> cancelInformation() {
        return orderMapper.cancelInformation();
    }

    public int getSales() {
        return orderMapper.getSales();
    }

    public int getOrderCount() {
        return orderMapper.getOrderCount();
    }

    public List<OrderDetailDto> findComplete() {
        return orderMapper.findComplete();
    }

    public List<String> getCategoryList() {
        return orderMapper.getCategoryList();
    }

    public List<Integer> getCountByCategory() {
        return orderMapper.getCountByCategory();
    }

    public List<String> getPetList() {
        return orderMapper.getPetList();
    }

    public List<Integer> getCountByUserPet() {
        return orderMapper.getCountByUserPet();
    }

    public List<String> getKindStatus() {
        List<String> getKindStatus = orderMapper.getKindStatus();
        String refund = "환불";
        getKindStatus.add(refund);
        Collections.sort(getKindStatus);

        return getKindStatus;
    }

    public List<Integer> getCountStatus() {
        List<Integer> countStatus = orderMapper.getCountStatus();
        List<RefundDto> refundDtos = refundMapper.findRefundList();
        int size = refundDtos.size();
        countStatus.add(size);
        return countStatus;
    }

    public List<SumByYearDto> sumByYear() {
        return orderMapper.sumByYear();
    }

    @Transactional
    public void changeProductAmount(int orderId) {
        try {
            int transaction = orderMapper.changeProductAmount(orderId);
            if (transaction == 0) {
                throw new RuntimeException("Transaction failed");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while changing product amount", e);
        }
    }
}


