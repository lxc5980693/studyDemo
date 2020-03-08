package com.sihui.design.patterns.reflect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.reflect.entity
 * @ClassName: UserEntity
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  22:12
 * @Version: 1.0
 */
public class UserEntity {
    private String name;
    private Integer age;

//    public UserEntity() {
//
//    }

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
