package com.example.demo.service.template;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.service.template
 * @ClassName: PayTemplateInterface
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-06  13:49
 * @Version: 1.0
 */
@Component
public abstract class PayTemplate {

    public void templateMethod(Runnable runnable) throws Exception {
        if (null == runnable){
            throw new Exception("线程为空");
        }
        beforeMethod();
        runnable.run();
        afterMethod();
    }

    public abstract void beforeMethod();

    public abstract void afterMethod();

}
