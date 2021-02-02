package com.ahuan.miaosha.service;

/**
 * @author ahuan
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/622:35
 */
public interface StockService {
    // 秒杀商品后减少库存
    void decrByStock(String stockName);

    // 秒杀商品前判断是否有库存
    Integer selectByExample(String stockName);
}
