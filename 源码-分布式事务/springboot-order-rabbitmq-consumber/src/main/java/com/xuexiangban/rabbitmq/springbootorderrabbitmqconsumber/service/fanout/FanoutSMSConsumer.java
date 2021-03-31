package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumber.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/6 0:38
 */
@Component
@RabbitListener(queues = {"sms.fanout.queue"})
public class FanoutSMSConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("sms fanout---接收到了订单信息是：->" + message);
    }
}
