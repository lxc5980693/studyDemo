package com.sihui.design.patterns.observer.jdkobserver.observable;

import java.util.Observable;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.jdkobserver.observable
 * @ClassName: MessageObServable
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  15:32
 * @Version: 1.0
 */
public class MessageObServable extends Observable {


    @Override
    public void notifyObservers(Object arg) {
        //设置为群发、默认不群发
        setChanged();
        //调用父类的notifyObServers方法进行群发
        super.notifyObservers(arg);
    }
}
