package com.xuexiangban.rabbitmq.springbootorderrabbitmqproducer.config;

import org.springframework.amqp.core.*;
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
public class TTLRabbitMqConfiguration {

    // 1: 声明注册direct模式的交换机
    @Bean
    public DirectExchange ttldirectExchange() {
        return new DirectExchange("ttl_direct_exchange", true, false);
    }

    // 队列的过期时间
    @Bean
    public Queue directttlQueue() {
        // 设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);// 这里一定是int类型，
        args.put("x-max-length", 5);// 这里一定是int类型，
        args.put("x-dead-letter-exchange","dead_direct_exchange");
        args.put("x-dead-letter-routing-key","dead");//fanout不需要配置
        return new Queue("ttl.direct.queue", true,false,false,args);
    }


    // 队列的过期时间
    @Bean
    public Queue directttlMessageQueue() {
        return new Queue("ttl.message.direct.queue", true);
    }


    @Bean
    public Binding ttlbingds() {
        return BindingBuilder.bind(directttlQueue()).to(ttldirectExchange()).with("ttl");
    }

    @Bean
    public Binding ttlmsgbingds() {
        return BindingBuilder.bind(directttlMessageQueue()).to(ttldirectExchange()).with("ttlmessage");
    }
}
