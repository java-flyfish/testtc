package com.test.tc.order.fegin.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CheckProductDto {

    /**
     * skuId
     */
    @NotNull(message = "skuid不能为空")
    private Long skuId;
}
