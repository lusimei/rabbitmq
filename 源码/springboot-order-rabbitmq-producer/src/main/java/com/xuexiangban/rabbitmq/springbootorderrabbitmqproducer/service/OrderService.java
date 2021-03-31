package com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/5 22:26
 */
@Service
public class OrderService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 交换机
    private String exchangeName = "fanout_order_ex";
    // 路由key
    private String routingKey = "";

    
    /**
     * @Author xuke
     * @Description 模拟用户购买商品下单的业务
     * @Date 22:26 2021/3/5
     * @Param [userId, productId, num]
     * @return void
    **/
    public void makeOrder(String userId,String productId,int num){
        // 1: 根据商品id查询库存是否充足
        // 2: 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("保存订单成功：id是：" + orderId);
        // 3: 发送消息
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }


    /**
     * @Author xuke
     * @Description 模拟用户购买商品下单的业务
     * @Date 22:26 2021/3/5
     * @Param [userId, productId, num]
     * @return void
     **/
    public void makeOrderDirect(String userId,String productId,int num){
        // 1: 根据商品id查询库存是否充足
        // 2: 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("保存订单成功：id是：" + orderId);
        // 3: 发送消息
        rabbitTemplate.convertAndSend("direct_order_ex","email",orderId);
        rabbitTemplate.convertAndSend("direct_order_ex","sms",orderId);
    }

//    /**
//     * @Author xuke
//     * @Description 模拟用户购买商品下单的业务
//     * @Date 22:26 2021/3/5
//     * @Param [userId, productId, num]
//     * @return void
//     **/
//    public void makeOrderDirectTtl(String userId,String productId,int num){
//        // 1: 根据商品id查询库存是否充足
//        // 2: 保存订单
//        String orderId = UUID.randomUUID().toString();
//        System.out.println("保存订单成功：id是：" + orderId);
//
//        MessagePostProcessor postProcessor = new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setContentEncoding("utf-8");
//                //设置消息存活时间
//                message.getMessageProperties().setExpiration("5000");
//                return message;
//            }
//        };
//
//        // 3: 发送消息
//        rabbitTemplate.convertAndSend("direct_order_ex","ttl",orderId,postProcessor);
//        rabbitTemplate.convertAndSend("direct_order_ex","weixin",orderId);
//    }
//


    /**
     * @Author xuke
     * @Description 模拟用户购买商品下单的业务
     * @Date 22:26 2021/3/5
     * @Param [userId, productId, num]
     * @return void
     **/
    public void makeOrderTopic(String userId,String productId,int num){
        // 1: 根据商品id查询库存是否充足
        // 2: 保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("保存订单成功：id是：" + orderId);
        // 3: 发送消息

        //com.#  duanxin
        //#.email.* email
        //#.sms.# sms
        // 设置消息确认机制
        rabbitTemplate.convertAndSend("topic_order_ex","com.email.sms.xxx",orderId);
    }
}
