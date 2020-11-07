package com.test.tc.order.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateOrderDto {
    /**
     * skuId
     */
    @NotNull(message = "skuid不能为空")
    private Long skuId;

    @NotNull(message = "商品数量不能为空")
    private Integer amount;

    @NotNull(message = "支付方式不能为空")
    private Byte payType;

    /**
     * 备注
     */
    private String note;
}
