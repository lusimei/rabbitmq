package com.xuexiangban.rabbitmq.springbootrabbitmqfanoutproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/4 22:10
 */
@Component
public class OrderService {


    // 模板方法模式
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 交换机
    private String exchangeName = "fanout_order_ex";
    // 路由key
    private String routingKey = "";


    /**
     * @return void
     * @Author xuke
     * @Description 下单方法
     * @Date 22:17 2021/3/4
     * @Param [userId, productId, num]
     **/
    public String makeorder(String userId, String productId, Integer num) {
        // 1: 根据用户查询用户是否存在
        // 2: 根据产品id查询产品信息
        String orderId = num+"";
        // 3: 保存订单
        // 4: 发送邮件，sms,短信
        System.out.println("用户：" + userId + ",购买了一个产品：" + productId + "保存订单是：" + orderId);
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);

        return "success";
    }

}
