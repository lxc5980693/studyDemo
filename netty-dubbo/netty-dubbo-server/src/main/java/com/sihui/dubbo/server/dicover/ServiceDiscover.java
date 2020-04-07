package com.sihui.dubbo.server.dicover;

import java.util.List;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.dicover
 * @ClassName: ServiceDiscover
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:07
 * @Version: 1.0
 */
public interface ServiceDiscover {

    /**
     * 根据服务名获取提供者，可能会存在多个
     * @param serviceName
     * @return
     */
    List<String> getService(String serviceName);
}
