package com.sihui.agent;

import java.lang.instrument.Instrumentation;

/**
 * @ProjectName: agent
 * @Package: com.sihui.agent
 * @ClassName: TestAgent
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-06-19  15:49
 * @Version: 1.0
 */
public class TestAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("TestAgent premain running");
        System.out.println("args: " + agentArgs);
    }
}
