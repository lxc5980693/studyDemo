package com.sihui.demo.base;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.base
 * @ClassName: MyFetcher
 * @Author: lixuanchen
 * @Description: 回调基础
 * @Date: 2020-06-04  16:57
 * @Version: 1.0
 */
public class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetcherDate(FetcherCallback fetcherCallback) {
        try {
            int i = data.m / data.n;
            System.out.println("MyFetcher fetcherDate result: " + i);
            fetcherCallback.onData(data);
        } catch (Exception e) {
            fetcherCallback.onError(e);
        }
    }
}
