package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumber.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/6 0:38
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "duanxin.topic.queue", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange", type = ExchangeTypes.TOPIC),
        key = "#.duanxin.#"

))
public class TopicDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("duanxin topic---接收到了订单信息是：->" + message);
    }
}
