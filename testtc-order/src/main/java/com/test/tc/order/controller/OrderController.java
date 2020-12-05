package com.test.tc.order.controller;

import com.test.tc.common.Result;
import com.test.tc.order.dto.CreateOrderDto;
import com.test.tc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Result<Boolean> createOrder(@RequestBody @Valid CreateOrderDto dto) throws InterruptedException {
        Boolean b = orderService.creatrOrder(dto);
        return Result.success(b);
    }
}
