package com.learn.strategysvc.strategy;

import com.learn.strategysvc.common.constant.LogisticsType;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leiichen
 * @Description
 * @create 2024-12-15 12:32
 */
@Component
public class LogisticsStrategyFactory implements InitializingBean {
    private final Map<LogisticsType, LogisticsStrategy> logisticsStrategyMap = new ConcurrentHashMap<>();

    @Resource
    private ApplicationContext applicationContext;
    @Override
    public void afterPropertiesSet() {
        Map<String, LogisticsStrategy> map = applicationContext.getBeansOfType(LogisticsStrategy.class);
        map.forEach((k, v) -> logisticsStrategyMap.put(v.getLogistics(), v));
    }

    public LogisticsStrategy getLogisticsStrategy(LogisticsType logisticsType) {
        return logisticsStrategyMap.get(logisticsType);
    }


}
