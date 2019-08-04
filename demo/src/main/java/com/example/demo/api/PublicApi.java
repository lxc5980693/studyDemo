package com.example.demo.api;

import com.example.demo.service.GetWayHandle;
import com.example.demo.service.impl.handle.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicApi {

    @Autowired
    private HandleService handleService;

    @RequestMapping("/handle")
    public String test(){
        GetWayHandle firstHandle = handleService.getFirstHandle();
        firstHandle.handleMethod();
        return "success";
    }
}
