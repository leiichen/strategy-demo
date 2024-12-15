package com.learn.strategysvc.request;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferFeeRequest {

    /**
     * 距离
     */
    private BigDecimal distance;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 快递类型
     */
    private String type;
}
