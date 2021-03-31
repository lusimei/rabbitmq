package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumer.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/5 22:38
 */
@Service
@RabbitListener(
    bindings = @QueueBinding(
            value = @Queue(value = "duanxin.topic.queue", autoDelete = "false"),
            exchange = @Exchange(value = "topic_order_ex", durable = "true", type = ExchangeTypes.TOPIC),
            key = "com.#"
    )
)
public class TopicDuanxinConsumber {


    // 告诉你的接收服务器的消息，没有返回值
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("duanxin--topic--->接收到订单消息，订单id是: " + message);
    }
}
