package com.sihui.design.patterns.observer.myobserver;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer
 * @ClassName: Subject
 * @Author: lixuanchen
 * @Description: 抽象主题接口
 * @Date: 2020-03-07  15:02
 * @Version: 1.0
 */
public interface SubjectInterface {

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    添加观察者 注册订阅者
     *  @Return  void
     *  @Exception
     *  @Date  2020-03-07  15:05
     *  @param
     */
    public void addObServer(ObServer obServer);

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    移除观察者 注册订阅者
     *  @Return  void
     *  @Exception
     *  @Date  2020-03-07  15:05
     *  @param
     */
    public void removeObServer(ObServer obServer);

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    通知观察者
     *  @Return  void
     *  @Exception
     *  @Date  2020-03-07  15:05
     *  @param
     */
    public void notifyObServers(String message);

}
