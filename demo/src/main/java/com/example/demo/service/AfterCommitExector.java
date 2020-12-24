package com.example.demo.service;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.service
 * @ClassName: AfterCommitExector
 * @Author: lixuanchen
 * @Description: 事务提交之后的业务处理接口
 * @Date: 2020-10-30  16:20
 * @Version: 1.0
 */
public interface AfterCommitExector {

    void submitTask(Runnable runnable);

}
