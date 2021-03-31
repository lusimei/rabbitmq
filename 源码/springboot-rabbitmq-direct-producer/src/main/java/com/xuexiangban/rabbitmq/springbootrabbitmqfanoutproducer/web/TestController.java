package com.xuexiangban.rabbitmq.springbootrabbitmqfanoutproducer.web;

import com.xuexiangban.rabbitmq.springbootrabbitmqfanoutproducer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/4 22:54
 */
@RestController
public class TestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    public String contextLoads() throws Exception {

        for (int i = 1; i <= 10; i++) {
            String result = orderService.makeorder("100", "100", i);
            Thread.sleep(1000);
            System.out.println(result);
        }

        return "success";
    }

}
