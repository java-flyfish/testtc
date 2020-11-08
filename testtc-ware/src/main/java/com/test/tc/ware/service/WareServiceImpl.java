package com.test.tc.ware.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.tc.common.BaseAppException;
import com.test.tc.ware.dao.WareSkuDao;
import com.test.tc.ware.dto.CheckWareDto;
import com.test.tc.ware.dto.DecrementSkuStockDto;
import com.test.tc.ware.entity.WareSkuEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class WareServiceImpl implements WareService {

    @Autowired
    private WareSkuDao wareSkuDao;

    @Override
    public Boolean ckeckWare(CheckWareDto dto) {

        QueryWrapper<WareSkuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("sku_id",dto.getSkuId()).ge("stock",dto.getAmount());

        WareSkuEntity wareSkuEntity = wareSkuDao.selectOne(wrapper);
        if (wareSkuEntity == null){
            throw new BaseAppException("30000","库存不足");
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean decrementSkuStock(DecrementSkuStockDto dto) {

        Integer i = wareSkuDao.decrementSkuStock(dto);
        int a = 1/0;
        if (i<1){
            throw new BaseAppException("30001","库存不足");
        }
        return true;
    }
}
