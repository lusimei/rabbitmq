package com.xuexiangban.rabbitmq;

import com.xuexiangban.rabbitmq.pojo.Order;
import com.xuexiangban.rabbitmq.service.MQOrderService;
import com.xuexiangban.rabbitmq.service.OrderService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KuangstudyOrderServiceApplicationTests {

    @Autowired
    public OrderService orderService;
    @Autowired
    public MQOrderService mqOrderService;


    @Test
    public void orderCreated() throws Exception {
        //订单生成
        String orderId = "1000001";
        Order orderInfo = new Order();
        orderInfo.setOrderId(orderId);
        orderInfo.setUserId(1);
        orderInfo.setOrderContent("买了一个方便面");
        orderService.createOrder(orderInfo);

        System.out.println("订单创建成功.......");
    }


    @Test
    public void orderCreatedMQ() throws Exception {
        //订单生成
        String orderId = "1000001";
        Order orderInfo = new Order();
        orderInfo.setOrderId(orderId);
        orderInfo.setUserId(1);
        orderInfo.setOrderContent("买了一个方便面");
        mqOrderService.createOrder(orderInfo);
        System.out.println("订单创建成功.......");

        //Thread.sleep(2000);
    }

}
