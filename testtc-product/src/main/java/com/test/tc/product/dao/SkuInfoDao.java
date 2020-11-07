package com.test.tc.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.tc.product.dto.IncrementSkuSaleDto;
import com.test.tc.product.entity.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * sku信息
 * 
 * @author weiyang
 * @email tongweiyang01@163.com
 * @date 2020-11-07 08:24:09
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {
    Integer incrementSkuSale(@Param("dto") IncrementSkuSaleDto dto);
}
