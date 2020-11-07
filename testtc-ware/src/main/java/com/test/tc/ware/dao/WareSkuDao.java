package com.test.tc.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.tc.ware.dto.DecrementSkuStockDto;
import com.test.tc.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存
 * 
 * @author weiyang
 * @email tongweiyang01@163.com
 * @date 2020-11-07 08:24:50
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    Integer decrementSkuStock(@Param("dto") DecrementSkuStockDto dto);
}
