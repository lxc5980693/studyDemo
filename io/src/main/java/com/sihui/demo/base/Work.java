package com.sihui.demo.base;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.base
 * @ClassName: Work
 * @Author: lixuanchen
 * @Description: 回调基础
 * @Date: 2020-06-04  16:59
 * @Version: 1.0
 */
public class Work {
    public void doWork(){
        Data data = new Data(1, 0);
        Fetcher fetcher = new MyFetcher(data);
        fetcher.fetcherDate(new FetcherCallback() {
            @Override
            public void onData(Data data) {
                System.out.println(data.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        Work work = new Work();
        work.doWork();
    }
}
