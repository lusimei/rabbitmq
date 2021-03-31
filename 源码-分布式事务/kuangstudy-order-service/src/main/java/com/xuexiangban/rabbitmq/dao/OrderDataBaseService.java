package com.xuexiangban.rabbitmq.dao;

import com.xuexiangban.rabbitmq.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderDataBaseService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 保存订单记录
	 */
	public void saveOrder(Order order) throws Exception{
		// 定义保存sql
		String sqlString = "insert into ksd_order(order_id,user_id,order_content)values(?,?,?)";

		// 1：添加订单记录
		int count = jdbcTemplate.update(sqlString,order.getOrderId(),order.getUserId(),order.getOrderContent());

		if(count!=1) {
			throw new Exception("订单创建失败，原因[数据库操作失败]");
		}

		//因为在下单可能会会rabbit会出现宕机，就引发消息是没有放入MQ.为来消息可靠生产，对消息做一次冗余
		saveLocalMessage(order);
	}
	






	/**
	 * 保存信息到本地
	 * @param order
	 */
	public  void saveLocalMessage(Order order) throws Exception{
		// 定义保存sql
		String sqlString = "insert into ksd_order_message(order_id,order_content,status,unique_id)values(?,?,?,?)";

		// 添加运动记录
		int count = jdbcTemplate.update(sqlString,order.getOrderId(),order.getOrderContent(),0,1);

		if(count!=1) {
			throw new Exception("出现异常，原因[数据库操作失败]");
		}

	}

}
