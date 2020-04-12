package com.sihui.dubbo.server.regist;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.regist
 * @ClassName: ServiceRegister
 * @Author: lixuanchen
 * @Description: 服务注册
 * @Date: 2020-03-02  21:45
 * @Version: 1.0
 */
public interface ServiceRegister {

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    服务注册
     *  @Return  void
     *  @Exception
     *  @Date  2020-03-02  21:46
     *  @param serviceName  com.sihui.UserService
     *  @param serviceAddress  sihui://
     */
    void regist(String serviceName,String serviceAddress);
}
