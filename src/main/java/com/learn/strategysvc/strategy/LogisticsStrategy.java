package com.learn.strategysvc.strategy;


import com.learn.strategysvc.common.constant.LogisticsType;
import com.learn.strategysvc.request.TransferFeeRequest;

import java.math.BigDecimal;

public interface LogisticsStrategy {
    /**
     * 获取物流类型
     * @return
     */
    LogisticsType getLogistics();

    /**
     * 计算运费
     * @param transferFeeRequest
     * @return
     */
    BigDecimal calculateFee(TransferFeeRequest transferFeeRequest);
}
