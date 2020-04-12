package com.sihui.proxy.entity;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.entity
 * @ClassName: User
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-09  15:20
 * @Version: 1.0
 */
public class User {
    private String name;
    private Integer age;
    private String address;

    public User(String name,Integer age,String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
