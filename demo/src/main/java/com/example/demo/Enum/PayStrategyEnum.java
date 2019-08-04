package com.example.demo.Enum;

public enum PayStrategyEnum {

    ALI_PAY("com.example.demo.service.impl.strategy.AliPayStrategy"),

    WEIXIN_PAY("com.example.demo.service.impl.strategy.WeixinPayStrategy");

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
