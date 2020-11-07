package com.test.tc.product.controller;

import com.test.tc.common.Result;
import com.test.tc.product.dto.CheckProductDto;
import com.test.tc.product.dto.IncrementSkuSaleDto;
import com.test.tc.product.service.ProductService;
import com.test.tc.product.vo.SkuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/checkProduct")
    public Result<SkuInfoVo> ckeckProduct(@RequestBody @Valid CheckProductDto dto){
        SkuInfoVo vo = productService.checkProduct(dto);
        return Result.success(vo);
    }

    @PostMapping("/incrementSkuSale")
    public Result<Boolean> incrementSkuSale(@RequestBody @Valid IncrementSkuSaleDto dto){
        Boolean b = productService.incrementSkuSale(dto);
        return Result.success(b);
    }
}
