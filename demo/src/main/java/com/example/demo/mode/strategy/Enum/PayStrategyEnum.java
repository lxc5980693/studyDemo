package com.example.demo.mode.strategy.Enum;

public enum PayStrategyEnum {

    ALI_PAY("com.example.demo.mode.strategy.service.impl.AliPayStrategy"),

    WEIXIN_PAY("com.example.demo.mode.strategy.service.impl.WeixinPayStrategy");

    private String path;

    PayStrategyEnum(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
