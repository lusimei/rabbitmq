package com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer;

import com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {


    @Autowired
    private OrderService orderService;


    @Test
    public void contextLoads() {
        orderService.makeOrder("100","100",10);
    }



    @Test
    public void testDirect() {
        orderService.makeOrderDirect("100","100",10);
    }

    @Test
    public void testDirectTTl() {
        orderService.makeOrderDirectTtl("100","100",10);
    }


    @Test
    public void testTopic() {
        orderService.makeOrderTopic("100","100",10);
    }

}
