package com.test.tc.ware.controller;


import com.test.tc.common.Result;
import com.test.tc.ware.dao.WareSkuDao;
import com.test.tc.ware.dto.CheckWareDto;
import com.test.tc.ware.dto.DecrementSkuStockDto;
import com.test.tc.ware.entity.WareSkuEntity;
import com.test.tc.ware.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ware")
public class WareController {

    @Autowired
    private WareService wareService;

    @Autowired
    private WareSkuDao wareSkuDao;


    @PostMapping("/checkWare")
    public Result<Boolean> ckeckWare(@RequestBody @Valid CheckWareDto dto){
        Boolean b = wareService.ckeckWare(dto);
        return Result.success(b);
    }

    @PostMapping("/decrementSkuStock")
    public Result<Boolean> decrementSkuStock(@RequestBody @Valid DecrementSkuStockDto dto){
        Boolean b = wareService.decrementSkuStock(dto);
        return Result.success(b);
    }

    @PostMapping("/addSkuStock")
    public Result<Boolean> addSkuStock(){

        wareService.addSkuStock();
        return Result.success(true);
    }
}
