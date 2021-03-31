//package com.xuexiangban.rabbitmq.task;
//
//import com.xuexiangban.rabbitmq.pojo.Order;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.List;
//
///**
// * @description:
// * @author: xuke
// * @time: 2021/3/7 16:07
// */
//@EnableScheduling
//public class TaskService {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Scheduled(cron = "0 0 0/2 ?")
//    public void sendMessage(){
//        // 把消息为0的状态消息重新查询出来，投递到MQ中。
//        List<Order> orderList = orderService.selectOrderMessage(0);
//        for (Order order : orderList) {
//            rabbitTemplate.convertAndSend("order-fanout_exchange","",order);
//        }
//    }
//}
