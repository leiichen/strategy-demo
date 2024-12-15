package com.learn.strategysvc.service;


import com.learn.strategysvc.request.TransferFeeRequest;

import java.math.BigDecimal;

public interface LogisticsService {

    boolean isCurrentLogistics(Integer type);

    BigDecimal calculateFee(TransferFeeRequest transferFeeRequest);
}
