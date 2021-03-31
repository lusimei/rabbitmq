package com.xuexiangban.rabbitmq.springbootorderrabbitmqconsumber.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/6 0:29
 */
@Configuration
public class DirectRabbitMqConfiguration {

    // 1: 声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    // 2: 声明队列 sms.direct.queue email.direct.queue,duanxin.direct.queue
    @Bean
    public Queue directsmsQueue() {
        return new Queue("sms.direct.queue", true);
    }

    @Bean
    public Queue directduanxinQueue() {
        return new Queue("duanxin.direct.queue", true);
    }

    @Bean
    public Queue directemailQueue() {
        return new Queue("email.direct.queue", true);
    }


    // 3: 完成绑定关系（队列和交换机完成绑定关系）
    @Bean
    public Binding directsmsBingding() {
        return BindingBuilder.bind(directsmsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding directemailBingding() {
        return BindingBuilder.bind(directemailQueue()).to(directExchange()).with("email");
    }

    @Bean
    public Binding directduanxinBingding() {
        return BindingBuilder.bind(directduanxinQueue()).to(directExchange()).with("duanxin");
    }
}
