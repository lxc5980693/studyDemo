package com.sihui.agent.demo.service;

import java.lang.instrument.Instrumentation;

/**
 * @ProjectName: agent-demo
 * @Package: com.sihui.agent.demo.service
 * @ClassName: TestAgent
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-06-22  10:25
 * @Version: 1.0
 */
public class TestAgent {
    public static void agentmain(String[] args, Instrumentation instrumentation) {
        System.out.println("loadAgent class running main args: " + args.toString());
        Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        for (Class allLoadedClass : allLoadedClasses) {
            System.out.println("load class: " + allLoadedClass.getName());
        }
        System.out.println("loadAgent class runn completely...");
    }
}
