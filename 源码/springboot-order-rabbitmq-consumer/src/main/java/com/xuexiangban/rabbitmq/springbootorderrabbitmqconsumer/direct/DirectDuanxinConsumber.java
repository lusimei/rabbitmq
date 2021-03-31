package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/5 22:38
 */
@Service
@RabbitListener(queues ={"duanxin.direct.queue"})
public class DirectDuanxinConsumber {


    // 告诉你的接收服务器的消息，没有返回值
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("duanxin--direct--->接收到订单消息，订单id是: " + message);
    }
}
