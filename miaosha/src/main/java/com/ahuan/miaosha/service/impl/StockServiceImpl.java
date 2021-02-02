package com.ahuan.miaosha.service.impl;

import com.ahuan.miaosha.dao.TStockMapper;
import com.ahuan.miaosha.model.TStock;
import com.ahuan.miaosha.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
/***
 * mq商品库存消费者
 */
@Service
public class StockServiceImpl implements StockService {
    @Resource
    private TStockMapper stockMapper;
    // 秒杀商品后减少库存
    @Override
    public void decrByStock(String stockName) {
        List<TStock> stocks = stockMapper.selectByStockName(stockName);
        if (!CollectionUtils.isEmpty(stocks)) {
            TStock stock = stocks.get(0);
            stock.setStock(stock.getStock() - 1);
            stockMapper.updateByPrimaryKey(stock);
        }
    }
    // 秒杀商品前判断是否有库存
    @Override
    public Integer selectByExample(String stockName) {
        List<TStock> stocks = stockMapper.selectByStockName(stockName);
        if (!CollectionUtils.isEmpty(stocks)) {
            return stocks.get(0).getStock().intValue();
        }
        return 0;
    }
}