package com.learn.strategysvc.service.impl;

import com.learn.strategysvc.common.constant.LogisticsType;
import com.learn.strategysvc.request.TransferFeeRequest;
import com.learn.strategysvc.strategy.LogisticsStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SFTransfercompany implements LogisticsStrategy {

    private BigDecimal pickFee = BigDecimal.TEN;

    private BigDecimal minDistance = BigDecimal.valueOf(60);

    @Override
    public LogisticsType getLogistics() {
        return LogisticsType.SFTransfer;
    }

    @Override
    public BigDecimal calculateFee(TransferFeeRequest transferFeeRequest) {
        BigDecimal distance = minDistance.compareTo(transferFeeRequest.getDistance()) > 0 ?
                minDistance : transferFeeRequest.getDistance();
        BigDecimal fee = distance.multiply(transferFeeRequest.getUnitPrice()).add(pickFee);
        return fee;
    }
}
