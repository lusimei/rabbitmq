package com.xuexiangban.rabbitmq.springbootrabbitmqtopicconsumer.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/4 22:33
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email.topic.queue", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_ex", type = ExchangeTypes.TOPIC),
        key = "#.email.#"
))
public class EmailConsumerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // @RabbitHandler 代表该方法会当做消费者的方法，如果有消息过来就会进入此方法
    @RabbitHandler
    public void reciverMessage(String message) {
        System.out.println("email开始接收消息：" + message);
    }


}
