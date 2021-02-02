package com.ahuan.miaosha.service.mq;

import com.ahuan.miaosha.conf.MyRabbitMQConfig;
import com.ahuan.miaosha.model.TOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * @ClassName MqSender mq生产者
 * @Description: MqSender.java
 * @Author Ahuan
 * @Date 2020/4/7 
 * @Version V1.0
 **/
@Component
public class MqSender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendOrderMessage(TOrder order){
        rabbitTemplate.convertAndSend(MyRabbitMQConfig.ORDER_EXCHANGE,MyRabbitMQConfig.ORDER_ROUTING_KEY,order);
    }

    public void sendStockMessage(String stockName){
        rabbitTemplate.convertAndSend(MyRabbitMQConfig.STORY_EXCHANGE,MyRabbitMQConfig.STORY_ROUTING_KEY,stockName);
    }
}