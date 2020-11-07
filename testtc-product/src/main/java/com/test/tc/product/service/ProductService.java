package com.test.tc.product.service;

import com.test.tc.product.dto.CheckProductDto;
import com.test.tc.product.dto.IncrementSkuSaleDto;
import com.test.tc.product.vo.SkuInfoVo;

public interface ProductService {
    SkuInfoVo checkProduct(CheckProductDto dto);

    Boolean incrementSkuSale(IncrementSkuSaleDto dto);
}
