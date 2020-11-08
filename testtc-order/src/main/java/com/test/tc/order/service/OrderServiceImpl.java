package com.test.tc.order.service;

import com.test.tc.common.BaseAppException;
import com.test.tc.common.Result;
import com.test.tc.order.dao.OrderDao;
import com.test.tc.order.dto.CreateOrderDto;
import com.test.tc.order.entity.OrderEntity;
import com.test.tc.order.fegin.ProductFeginClient;
import com.test.tc.order.fegin.WareFeginClient;
import com.test.tc.order.fegin.dto.CheckProductDto;
import com.test.tc.order.fegin.dto.CheckWareDto;
import com.test.tc.order.fegin.dto.DecrementSkuStockDto;
import com.test.tc.order.fegin.dto.IncrementSkuSaleDto;
import com.test.tc.order.fegin.vo.SkuInfoVo;
import com.test.tc.order.utils.ElevocIdGenerator;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductFeginClient productFeginClient;

    @Autowired
    private WareFeginClient wareFeginClient;

    @Autowired
    private OrderDao orderDao;

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean creatrOrder(CreateOrderDto dto) {

        //校验商品
        CheckProductDto checkProductDto = new CheckProductDto();
        checkProductDto.setSkuId(dto.getSkuId());
        Result<SkuInfoVo> checkProductResult = productFeginClient.checkProduct(checkProductDto);
        if (!checkProductResult.getSuccess()){
            throw new BaseAppException("20000","商品不存在");
        }

        SkuInfoVo skuInfoVo = checkProductResult.getData();
        //校验库存
        CheckWareDto checkWareDto = new CheckWareDto();
        checkWareDto.setSkuId(dto.getSkuId());
        checkWareDto.setAmount(dto.getAmount());
        Result<Boolean> checkWareResult = wareFeginClient.checkWare(checkWareDto);
        if (!checkWareResult.getSuccess()){
            throw new BaseAppException("20001","商品库存不足");
        }

        //下面开始分布式事务
        //创建订单
        Date now = new Date();
        OrderEntity orderEntity = new OrderEntity();
        //订单号
        orderEntity.setOrderSn(ElevocIdGenerator.uuid32());
        //创建时间
        orderEntity.setCreateTime(now);
        //总数
        orderEntity.setTotalAmount(dto.getAmount());
        //总价
        orderEntity.setPayAmount(skuInfoVo.getPrice().multiply(new BigDecimal(dto.getAmount())));
        //支付方式
        orderEntity.setPayType(dto.getPayType());
        //订单状态，待发货
        orderEntity.setStatus((byte)1);
        //备注
        orderEntity.setNote(dto.getNote());
        //未确认收货
        orderEntity.setConfirmStatus((byte)0);
        //未删除
        orderEntity.setDeleteStatus(false);
        //支付时间
        orderEntity.setPaymentTime(now);
        orderEntity.setModifyTime(now);
        //插入订单，这里是本地事务
        orderDao.insert(orderEntity);

        //商品已售加增加
        IncrementSkuSaleDto incrementSkuSaleDto = new IncrementSkuSaleDto();
        incrementSkuSaleDto.setSkuId(dto.getSkuId());
        incrementSkuSaleDto.setAmount(dto.getAmount());
        Result<Boolean> incrementSkuSaleResult = productFeginClient.incrementSkuSale(incrementSkuSaleDto);
        if (!incrementSkuSaleResult.getSuccess()){
            throw new BaseAppException("20002","商品已售增加失败");
        }

        //sku扣减库存
        DecrementSkuStockDto decrementSkuStockDto = new DecrementSkuStockDto();
        decrementSkuStockDto.setSkuId(dto.getSkuId());
        decrementSkuStockDto.setAmount(dto.getAmount());
        Result<Boolean> decrementSkuStockResult = wareFeginClient.decrementSkuStock(decrementSkuStockDto);
        if (!decrementSkuStockResult.getSuccess()){
            throw new BaseAppException("20003","商品扣库存失败");
        }
        return true;
    }
}
