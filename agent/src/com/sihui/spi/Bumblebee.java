package com.sihui.spi;

/**
 * @ProjectName: agent
 * @Package: com.sihui.spi
 * @ClassName: Bumblebee
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-08-17  14:29
 * @Version: 1.0
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("hello baby!!! my name is bumblebee");
    }
}
