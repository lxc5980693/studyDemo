package com.sihui.collection.hashMap8;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap8
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-12  20:54
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        for (int i=0;;++i){
            System.out.println(i+"-----");
            if (i==4){
                break;
            }
            System.out.println(i+"~~~~~");
        }
    }
}
