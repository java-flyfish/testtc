package com.test.tc.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * 
 * @author weiyang
 * @email tongweiyang01@163.com
 * @date 2020-11-07 08:23:10
 */
@Data
@TableName("oms_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 订单号
	 */
	private String orderSn;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 订单总数
	 */
	private Integer totalAmount;
	/**
	 * 应付总额
	 */
	private BigDecimal payAmount;
	/**
	 * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
	 */
	private Byte payType;
	/**
	 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	 */
	private Byte status;
	/**
	 * 订单备注
	 */
	private String note;
	/**
	 * 确认收货状态[0->未确认；1->已确认]
	 */
	private Byte confirmStatus;
	/**
	 * 删除状态【0->未删除；1->已删除】
	 */
	private Boolean deleteStatus;
	/**
	 * 支付时间
	 */
	private Date paymentTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

}
