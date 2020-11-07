package com.test.tc.order.fegin;

import com.test.tc.common.Result;
import com.test.tc.order.fegin.dto.CheckWareDto;
import com.test.tc.order.fegin.dto.DecrementSkuStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("testtc-ware")
public interface WareFeginClient {

    @PostMapping("/ware/checkWare")
    Result<Boolean> checkWare(@RequestBody CheckWareDto dto);

    @PostMapping("/ware/decrementSkuStock")
    Result<Boolean> decrementSkuStock(@RequestBody DecrementSkuStockDto dto);
}
