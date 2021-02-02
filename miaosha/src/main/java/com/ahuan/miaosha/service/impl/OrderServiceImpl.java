package com.ahuan.miaosha.service.impl;

import com.ahuan.miaosha.dao.TOrderMapper;
import com.ahuan.miaosha.model.TOrder;
import com.ahuan.miaosha.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * mq订单消费者
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private TOrderMapper orderMapper;
    @Override
    public void createOrder(TOrder order) {
        orderMapper.insert(order);
    }
}