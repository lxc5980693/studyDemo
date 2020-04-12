package com.sihui.dubbo.server.regist.impl;

import com.sihui.dubbo.server.regist.ServiceRegister;
import org.I0Itec.zkclient.ZkClient;

import java.net.URLEncoder;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.regist.impl
 * @ClassName: ServiceRegisterImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  21:50
 * @Version: 1.0
 */
public class ServiceRegisterImpl implements ServiceRegister {
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

    public ServiceRegisterImpl() {
        //建立zk连接
        zkClient = new ZkClient(zkServer, connectionTimeout);
    }


    /**
     * @param serviceName    com.sihui.UserService
     * @param serviceAddress sihui://
     * @param serviceAddress
     * @Author lixuanchen
     * @Version 1.0
     * @Description 服务注册
     * @Return void
     * @Exception
     * @Date 2020-03-02  21:46
     */
    @Override
    public void regist(String serviceName, String serviceAddress) {
        //创建我们的跟路径
        if (!zkClient.exists(ROOT_NAME_PATH)) {
            //如果不存在，创建持久根路径节点
            zkClient.createPersistent(ROOT_NAME_PATH);
        }
        //注册我们的serviceName节点(根路径下的服务名称节点) /sihui_rpc/com.sihui.UserService
        String serviceNodePath = ROOT_NAME_PATH + "/" + serviceName;
        if (!zkClient.exists(serviceNodePath)) {
            zkClient.createPersistent(serviceNodePath);
        }
        //创建我们服务者节点,/sihui_rpc/com.sihui.UserService/providers
        String serviceProviderNodePath = serviceNodePath + PROVIDERS_NODE_PATH;
        if (!zkClient.exists(serviceProviderNodePath)){
            zkClient.createPersistent(serviceProviderNodePath);
        }
        //创建我们的服务地址
        String providerNameNodePath = serviceProviderNodePath + "/" + URLEncoder.encode(serviceAddress);
        if (zkClient.exists(providerNameNodePath)){
            //如果存在已注册的节点，删除重新注册
            zkClient.delete(providerNameNodePath);
        }
        zkClient.createEphemeral(providerNameNodePath);
    }
}
