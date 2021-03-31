package com.xuexiangban.rabbitmq.springbootrabbitmqfanoutconsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/4 22:33
 */
@Component
@RabbitListener(queues = {"weixin.direct.queue"})
public class WeixinConsumerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // @RabbitHandler 代表该方法会当做消费者的方法，如果有消息过来就会进入此方法
    @RabbitHandler
    public void reciverMessage(String message) {
        System.out.println("direct 微信开始接收消息：" + message);
    }


}
