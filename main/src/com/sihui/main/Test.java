package com.sihui.main;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @ProjectName: main
 * @Package: com.sihui.main
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-06-19  16:38
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        try {
            VirtualMachine attach = VirtualMachine.attach("86049");
            attach.loadAgent("/Users/lixuanchen/Desktop/studyDemo/agent-demo/target/agent-demo-0.0.1-SNAPSHOT.jar");
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }
        System.out.println("main Project main method running....");
    }
}
