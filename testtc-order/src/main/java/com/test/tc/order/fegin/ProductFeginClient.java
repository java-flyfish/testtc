package com.test.tc.order.fegin;

import com.test.tc.common.Result;
import com.test.tc.order.fegin.dto.CheckProductDto;
import com.test.tc.order.fegin.dto.IncrementSkuSaleDto;
import com.test.tc.order.fegin.vo.SkuInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("testtc-product")
public interface ProductFeginClient {

    @PostMapping("/product/checkProduct")
    Result<SkuInfoVo> checkProduct(@RequestBody CheckProductDto dto);

    @PostMapping("/product/incrementSkuSale")
    Result<Boolean> incrementSkuSale(@RequestBody IncrementSkuSaleDto dto);
}
