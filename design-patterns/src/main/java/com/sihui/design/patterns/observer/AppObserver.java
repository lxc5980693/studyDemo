package com.sihui.design.patterns.observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer
 * @ClassName: AppObserver
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  16:18
 * @Version: 1.0
 */
@SpringBootApplication
@EnableAsync
public class AppObserver {
    public static void main(String[] args) {
        SpringApplication.run(AppObserver.class, args);
    }
}
