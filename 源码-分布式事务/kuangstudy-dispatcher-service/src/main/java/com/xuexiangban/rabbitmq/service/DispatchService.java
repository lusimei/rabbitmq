package com.xuexiangban.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class DispatchService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * @Author xuke
     * @Description 运单的接收
     * @Date 15:23 2021/3/7
     * @Param [orderId]
     * @return void
    **/
    public void dispatch(String orderId) throws Exception {
        // 定义保存sql
        String sqlString = "insert into ksd_dispather_order(order_id,dispatch_id,status,order_content,user_id)values(?,?,?,?,?)";
        // 添加运动记录
        int count = jdbcTemplate.update(sqlString, orderId, UUID.randomUUID().toString(), 0, "木子鱼买了一个泡面", "1");

        if (count != 1) {
            throw new Exception("订单创建失败，原因[数据库操作失败]");
        }

    }


}
