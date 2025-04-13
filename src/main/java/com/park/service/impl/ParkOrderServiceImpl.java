package com.park.service.impl;

import com.park.mapper.ParkOrderMapper;
import com.park.model.ParkOrder;
import com.park.service.ParkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hxy
 * @create 2024-4-12 15:11
 */
@Service
public class ParkOrderServiceImpl implements ParkOrderService {
    @Autowired
    private ParkOrderMapper pom;
    //获取订单信息
    public List<ParkOrder> getAllOrder()
    {
        return pom.selectList(null);
    }
}
