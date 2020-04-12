package com.sihui.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.api.dto
 * @ClassName: UserEntity
 * @Author: lixuanchen
 * @Description: 用户实体
 * @Date: 2020-03-02  22:57
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class UserEntity implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private String age;
    /**
     * 地址
     */
    private String address;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
