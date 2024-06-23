package com.playground.admin_page.main.refund.model.dao;

import com.playground.admin_page.main.refund.model.dto.RefundDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefundMapper {
    List<RefundDto> findRefundList();
}
