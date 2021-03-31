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
    public DirectExchange fadoutExchange() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new DirectExchange("fanout_order_ex", true, false);
    }

    @Bean
    public Queue duanxinQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("duanxin.fanout.queue");
    }

    @Bean
    public Binding bindingDirect11() {
        return BindingBuilder.bind(duanxinQueue()).to(fadoutExchange()).with("");
    }

}
