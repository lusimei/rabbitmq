package com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer;

import com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    //fanout
    @Test
    public  void contextLoads() {
        orderService.makeOrder("1", "1", 12);
    }


    //direct
    @Test
    public void testorderDirect() {
        orderService.makeOrderDirect("1", "1", 12);
    }


    //topic
    @Test
    public void testorderTopic() {
        orderService.makeOrdertopic("1", "1", 12);
    }


    //ttl
    @Test
    public void testmakeOrderTtl() {

        for (int i = 0; i <11 ; i++) {
            orderService.makeOrderTtl("1", "1", 12);
        }
    }

    //ttlmessage
    @Test
    public void testmakeOrderTtlMessage() {
        orderService.makeOrderTtlMessage("1", "1", 12);
    }

}
