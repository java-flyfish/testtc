package com.test.tc.order.service;

import com.test.tc.order.dto.CreateOrderDto;

public interface OrderService {
    Boolean creatrOrder(CreateOrderDto dto) throws InterruptedException;
}
