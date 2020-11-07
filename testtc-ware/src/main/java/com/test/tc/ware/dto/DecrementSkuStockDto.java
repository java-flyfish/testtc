package com.test.tc.ware.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DecrementSkuStockDto {

    @NotNull(message = "skuId不能为空")
    private Long skuId;

    @NotNull(message = "商品数量不能为空")
    private Integer amount;
}
