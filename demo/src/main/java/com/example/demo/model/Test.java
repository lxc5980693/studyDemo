package com.example.demo.model;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.model
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-11-11  15:38
 * @Version: 1.0
 */
public class Test {

    private static final BigDecimal BIGDECIMAL3 = new BigDecimal(Integer.valueOf(100));

    public static void common(User user) {
        Address address = user.getAddress();
        address.setAddressCode(1234567L);
    }

    public static void main(String[] args) {
//        User user = new User(new Address("addressli", 94L), 26, "李炫辰");
//        User user1 = new User(new Address("addressZhang", 98L), 22, "呱呱");
//        List<User> users = new ArrayList<User>();
//        users.add(user);
//        users.add(user1);
//        List<User> collect = users.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
//
//        System.out.println(collect.toString());

        String json = "[{\"organization_id\":\"\",\"organization_name\":\"乌冬煤矿\",\"organization_abbreviation\":\"乌冬煤矿\"},{\"organization_id\":\"000000000000000000200100000000010000\",\"organization_name\":\"国家能源投资集团有限责任公司\",\"organization_abbreviation\":\"国能集团\"}]";
        List<DemoModel> demoModels = JSONObject.parseArray(json, DemoModel.class);
        System.out.println(demoModels.toString());
    }
}
