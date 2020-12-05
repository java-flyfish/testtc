package com.test.tc.ware.service;

import com.test.tc.ware.dto.CheckWareDto;
import com.test.tc.ware.dto.DecrementSkuStockDto;

public interface WareService {
    Boolean ckeckWare(CheckWareDto dto);

    Boolean decrementSkuStock(DecrementSkuStockDto dto);

    void addSkuStock();

}
