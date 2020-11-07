package com.test.tc.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.tc.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author weiyang
 * @email tongweiyang01@163.com
 * @date 2020-11-07 08:23:10
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
