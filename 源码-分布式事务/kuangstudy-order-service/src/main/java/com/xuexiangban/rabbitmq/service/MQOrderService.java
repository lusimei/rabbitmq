package com.xuexiangban.rabbitmq.service;

import com.xuexiangban.rabbitmq.dao.OrderDataBaseService;
import com.xuexiangban.rabbitmq.mq.OrderMQService;
import com.xuexiangban.rabbitmq.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class MQOrderService {


	@Autowired
	private OrderDataBaseService orderDataBaseService;
	@Autowired
	private OrderMQService orderMQService;

	// 创建订单
	public void createOrder(Order orderInfo) throws Exception {
		// 1: 订单信息--插入丁订单系统，订单数据库事务
		orderDataBaseService.saveOrder(orderInfo);
		// 2：通過Http接口发送订单信息到运单系统
		orderMQService.sendMessage(orderInfo);
	}

}
