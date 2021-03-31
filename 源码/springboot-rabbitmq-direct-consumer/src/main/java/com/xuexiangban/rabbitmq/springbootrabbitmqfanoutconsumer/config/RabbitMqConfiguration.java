package com.xuexiangban.rabbitmq.springbootrabbitmqfanoutconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: xuke
 * @time: 2021/3/4 22:24
 */
@Configuration
public class RabbitMqConfiguration {


    @Bean
    public DirectExchange directExchange() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new DirectExchange("direct_order_ex", true, false);
    }

    @Bean
    public Queue duanxinQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("duanxin.direct.queue");
    }

    @Bean
    public Binding bindingDirect11() {
        return BindingBuilder.bind(duanxinQueue()).to(directExchange()).with("");
    }


    @Bean
    public Queue emailQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("email.direct.queue");
    }

    @Bean
    public Queue smsQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("sms.direct.queue");
    }

    @Bean
    public Queue weixinQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("weixin.direct.queue");
    }


    @Bean
    public Binding bindingDirect14() {
        return BindingBuilder.bind(weixinQueue()).to(directExchange()).with("weixin");
    }

    @Bean
    public Binding bindingDirect12() {
        return BindingBuilder.bind(smsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding bindingDirect3() {
        return BindingBuilder.bind(emailQueue()).to(directExchange()).with("email");
    }

}
