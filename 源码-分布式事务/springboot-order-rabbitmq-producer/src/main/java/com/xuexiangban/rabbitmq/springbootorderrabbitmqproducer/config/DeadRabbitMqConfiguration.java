package com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/6 0:29
 */
@Configuration
public class DeadRabbitMqConfiguration {

    // 1: 声明注册direct模式的交换机
    @Bean
    public DirectExchange deadDirect() {
        return new DirectExchange("dead_direct_exchange", true, false);
    }

    // 队列的过期时间
    @Bean
    public Queue deadqueue() {
        // 设置过期时间
        return new Queue("dead.direct.queue", true);
    }

    @Bean
    public Binding deadbinds() {
        return BindingBuilder.bind(deadqueue()).to(deadDirect()).with("dead");
    }
}
