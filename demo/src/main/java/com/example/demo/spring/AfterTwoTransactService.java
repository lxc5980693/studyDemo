package com.example.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;

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
public class AfterTwoTransactService extends TransactionSynchronizationAdapter {

    private final Runnable runnable;

    public AfterTwoTransactService(Runnable runnable){
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
