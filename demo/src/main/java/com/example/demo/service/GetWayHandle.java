package com.example.demo.service;

public abstract class GetWayHandle {

    protected GetWayHandle nextGetWayHandle;

    public abstract void handleMethod();

    public void nextHandleMethod(){
        if (nextGetWayHandle != null){
            nextGetWayHandle.handleMethod();
        }
    }

    public void setNextGetWayHandle(GetWayHandle nextGetWayHandle) {
        this.nextGetWayHandle = nextGetWayHandle;
    }
}
