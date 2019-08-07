package com.example.demo.api;

import com.example.demo.service.template.PayTemplate;
import com.example.demo.service.template.impl.WeixinPayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.api
 * @ClassName: TemplateApi
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-06  16:33
 * @Version: 1.0
 */
@RestController
public class TemplateApi {

    @Autowired
    private WeixinPayImpl weixinPay;

    @RequestMapping("/template")
    public String template() throws Exception {
        weixinPay.templateMethod(() -> {
            int count = 10;
            for (int i = 0; i < 10; i++) {
                System.out.println("current count: " + count);
                count -= 1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return "success";
    }
}
