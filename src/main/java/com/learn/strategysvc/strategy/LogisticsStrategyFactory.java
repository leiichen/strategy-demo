package com.learn.strategysvc.strategy;

import com.learn.strategysvc.common.constant.LogisticsType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leiichen
 * @Description
 * @create 2024-12-15 12:32
 */
@Component
public class LogisticsStrategyFactory {
    private final Map<LogisticsType, LogisticsStrategy> logisticsStrategyMap = new ConcurrentHashMap<>();


    public LogisticsStrategy getLogisticsStrategy(LogisticsType logisticsType) {
        return logisticsStrategyMap.get(logisticsType);
    }
}
