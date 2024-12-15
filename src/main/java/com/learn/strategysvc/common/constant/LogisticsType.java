package com.learn.strategysvc.common.constant;

/**
 * @author leiichen
 * @Description
 * @create 2024-12-15 14:22
 */
public enum LogisticsType {
    JDTransfer("jd_transfer", "京东配送"),
    SFTransfer("sf_transfer", "顺丰配送"),
    YTTransfer("yt_transfer", "圆通配送"),
    ZTTransfer("zt_transfer", "中通配送"),
    ;

    private final String code;
    private final String desc;

    LogisticsType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LogisticsType getByCode(String code) {
        for (LogisticsType logisticsType : LogisticsType.values()) {
            if (logisticsType.getCode().equals(code)) {
                return logisticsType;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
