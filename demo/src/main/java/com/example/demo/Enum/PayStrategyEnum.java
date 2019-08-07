package com.example.demo.Enum;

public enum PayStrategyEnum {

    ALI_PAY("com.example.demo.service.strategy.impl.AliPayStrategy"),

    WEIXIN_PAY("com.example.demo.service.strategy.WeixinPayStrategy");

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
