package com.sihui.dubbo.server.dicover.impl;

import com.sihui.dubbo.server.dicover.ServiceDiscover;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.dicover.impl
 * @ClassName: ServiceDiscoverImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:08
 * @Version: 1.0
 */
public class ServiceDiscoverImpl implements ServiceDiscover {

    /**
     * zk连接地址
     */
    private static final String zkServer = "127.0.0.1";

    /**
     * 超时时间
     */
    private static final int connectionTimeout = 5000;

    /**
     * zk客户端
     */
    private ZkClient zkClient;

    /**
     * zk根节点路径名称
     */
    private static final String ROOT_NAME_PATH = "/sihui_rpc";

    /**
     * 服务提供者节点名称
     */
    private static final String PROVIDERS_NODE_PATH = "/providers";

    public ServiceDiscoverImpl(){
        zkClient = new ZkClient(zkServer, connectionTimeout);
    }

    /**
     * 根据服务名获取提供者，可能会存在多个
     *
     * @param serviceName
     * @return
     */
    @Override
    public List<String> getService(String serviceName) {
        List<String> children = zkClient.getChildren(ROOT_NAME_PATH.concat("/").concat(serviceName).concat(PROVIDERS_NODE_PATH));
        return children;
    }
}
