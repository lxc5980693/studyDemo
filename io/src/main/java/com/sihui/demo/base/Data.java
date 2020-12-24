package com.sihui.demo.base;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.base
 * @ClassName: Data
 * @Author: lixuanchen
 * @Description: 回调基础
 * @Date: 2020-06-04  16:47
 * @Version: 1.0
 */
public class Data {
    int m;
    int n;

    public Data(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }
}
