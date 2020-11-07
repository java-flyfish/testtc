package com.test.tc.product.service;

import com.test.tc.common.BaseAppException;
import com.test.tc.product.dao.SkuInfoDao;
import com.test.tc.product.dto.CheckProductDto;
import com.test.tc.product.dto.IncrementSkuSaleDto;
import com.test.tc.product.entity.SkuInfoEntity;
import com.test.tc.product.vo.SkuInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SkuInfoDao skuInfoDao;

    @Override
    public SkuInfoVo checkProduct(CheckProductDto dto) {

        SkuInfoEntity skuInfoEntity = skuInfoDao.selectById(dto.getSkuId());
        if (skuInfoEntity == null){
            throw new BaseAppException("10000","sku不存在！");
        }

        SkuInfoVo vo = new SkuInfoVo();
        BeanUtils.copyProperties(skuInfoEntity,vo);
        return vo;
    }

    @Override
    public Boolean incrementSkuSale(IncrementSkuSaleDto dto) {

        Integer i = skuInfoDao.incrementSkuSale(dto);
        if (i<1){
            throw new BaseAppException("10001","增加已售数量失败");
        }
        return true;

    }
}
