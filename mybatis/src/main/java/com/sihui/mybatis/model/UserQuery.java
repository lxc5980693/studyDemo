package com.sihui.mybatis.model;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.model
 * @ClassName: UserQuery
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-07-19  09:35
 * @Version: 1.0
 */
public class UserQuery {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
