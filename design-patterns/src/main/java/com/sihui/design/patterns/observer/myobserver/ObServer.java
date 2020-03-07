package com.sihui.design.patterns.observer.myobserver;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer
 * @ClassName: ObServer
 * @Author: lixuanchen
 * @Description: 抽象观察者
 * @Date: 2020-03-07  15:03
 * @Version: 1.0
 */
public interface ObServer {

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    主题发送消息方法
     *  @Return  void
     *  @Exception
     *  @Date  2020-03-07  15:03
     *  @param message
     */
    public void update(String message);
}
