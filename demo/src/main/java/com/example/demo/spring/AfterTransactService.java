package com.example.demo.spring;

import com.example.demo.service.AfterCommitExector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.queue
 * @ClassName: AfterTransactService
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-10-27  15:39
 * @Version: 1.0
 */
@Slf4j
public class AfterTransactService extends TransactionSynchronizationAdapter {

    private final Runnable runnable;

    public AfterTransactService(Runnable runnable){
        this.runnable = runnable;
    }

    @Override
    public void afterCommit() {
        log.info("AfterTransactService -> afterCommit begin");
        this.runnable.run();
    }

    @Override
    public void afterCompletion(int status) {
        log.info("AfterTransactService -> afterCompletion ststus:{}", status);
    }
}
