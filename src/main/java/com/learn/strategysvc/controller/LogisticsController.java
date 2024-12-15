package com.learn.strategysvc.controller;



import com.learn.strategysvc.common.constant.LogisticsType;
import com.learn.strategysvc.request.TransferFeeRequest;
import com.learn.strategysvc.strategy.LogisticsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LogisticsController {

//    @Autowired
//    private LogisticsService logisticsService;

    @Autowired
    private List<LogisticsStrategy> logisticsStrategies;


//    @PostMapping("/calculate")
//    private BigDecimal calculateFee(@RequestBody TransferFeeRequest transferFeeRequest) {
//
//        LogisticsService logisticsService = this.logisticsService.stream().filter(l -> l.isCurrentLogistics(transferFeeRequest.getType()))
//                .findFirst().orElse(null);
//        if (logisticsService != null) {
//            return logisticsService.calculateFee(transferFeeRequest);
//        }
//        return null;
//    }

    @PostMapping("/calculate")
    private BigDecimal calculateFee(@RequestBody TransferFeeRequest transferFeeRequest) {

        LogisticsStrategy logisticsStrategy = this.logisticsStrategies.stream().filter(l -> l.getLogistics().equals(LogisticsType.getByCode(transferFeeRequest.getType())))
                .findFirst().orElse(null);
        if (logisticsStrategy != null) {
            return logisticsStrategy.calculateFee(transferFeeRequest);
        }
        return null;
    }
}
