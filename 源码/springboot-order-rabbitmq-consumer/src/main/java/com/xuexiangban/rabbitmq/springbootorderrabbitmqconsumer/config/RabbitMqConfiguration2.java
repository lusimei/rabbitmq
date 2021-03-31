package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/5 22:30
 */
@Configuration
public class RabbitMqConfiguration2 {


    // 1： 声明交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_ex", true, false);
    }


    // 2: 声明队列 duanxin.direct.queue
    @Bean
    public Queue duanxinqueue() {
        return new Queue("duanxin.direct.queue", true);
    }


    // 2: 声明队列 duanxin.direct.queue
    @Bean
    public Queue smsqueue() {
        return new Queue("sms.direct.queue", true);
    }


    // 2: 声明队列 duanxin.direct.queue
    @Bean
    public Queue emailqueue() {
        return new Queue("email.direct.queue", true);
    }


    // 3: 确定绑定关系
    @Bean
    public Binding bindduanxin(){
        return BindingBuilder.bind(duanxinqueue()).to(directExchange()).with("msg");
    }

    // 3: 确定绑定关系
    @Bean
    public Binding bindsms(){
        return BindingBuilder.bind(smsqueue()).to(directExchange()).with("sms");
    }

    // 3: 确定绑定关系
    @Bean
    public Binding bindemail(){
        return BindingBuilder.bind(emailqueue()).to(directExchange()).with("email");
    }
}
