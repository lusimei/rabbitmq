package com.xuexiangban.rabbitmq.springbootrabbitmqfanoutproducer.config;

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


    /*
        // 如果你用界面把queueu 和 exchange的关系先绑定话，你代码就不需要在编写这些声明代码可以让代码变得更加简洁，但是不容读懂
        // 如果用代码的方式去声明，我们要学习一下
        // 7： 声明交换机 所谓的持久化就是指，交换机会不会随着服务器重启造成丢失，如果是true代表不丢失，false重启就会丢失
        channel.exchangeDeclare(exchangeName,exchangeType,true);

        // 8： 声明队列
        channel.queueDeclare("queue5",true,false,false,null);
        channel.queueDeclare("queue6",true,false,false,null);
        channel.queueDeclare("queue7",true,false,false,null);

        // 9：绑定队列和交换机的关系
        channel.queueBind("queue5",exchangeName,"order");
        channel.queueBind("queue6",exchangeName,"order");
        channel.queueBind("queue7",exchangeName,"course");
    */


    @Bean
    public DirectExchange fadoutExchange() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new DirectExchange("fanout_order_ex", true, false);
    }

    @Bean
    public Queue emailQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("email.fanout.queue");
    }

    @Bean
    public Queue smsQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("sms.fanout.queue");
    }

    @Bean
    public Queue weixinQueue() {
        // 等价于  channel.exchangeDeclare(exchangeName,exchangeType,true);
        return new Queue("weixin.fanout.queue");
    }


    @Bean
    public Binding bindingDirect11() {
        return BindingBuilder.bind(weixinQueue()).to(fadoutExchange()).with("");
    }

    @Bean
    public Binding bindingDirect12() {
        return BindingBuilder.bind(smsQueue()).to(fadoutExchange()).with("");
    }

    @Bean
    public Binding bindingDirect3() {
        return BindingBuilder.bind(emailQueue()).to(fadoutExchange()).with("");
    }

}
