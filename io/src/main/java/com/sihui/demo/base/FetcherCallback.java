package com.sihui.demo.base;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.base
 * @ClassName: FetcherCallback
 * @Author: lixuanchen
 * @Description: 回调函数
 * @Date: 2020-06-04  16:46
 * @Version: 1.0
 */
public interface FetcherCallback {

    void onData(Data data);

    void onError(Throwable throwable);
}
