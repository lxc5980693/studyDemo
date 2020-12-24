package com.example.demo.service;

import com.example.demo.spring.AfterTransactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.service
 * @ClassName: AfterCommitExectorImpl
 * @Author: lixuanchen
 * @Description: 事务提交之后的业务处理
 * @Date: 2020-11-02  15:52
 * @Version: 1.0
 */

@Service
@Slf4j
public class AfterCommitExectorTwoImpl implements AfterCommitExector {

    @Override
    public void submitTask(Runnable runnable) {
        if (TransactionSynchronizationManager.isActualTransactionActive()){
            log.info("[tx] It's in a active transaction, delay the task execte");
            TransactionSynchronizationManager.registerSynchronization(new AfterTransactService(runnable));
        }else {
            log.info("[tx] It's not in a active transaction, execte task directly");
            runnable.run();
        }
    }
}
