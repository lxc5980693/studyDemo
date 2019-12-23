package com.sihui.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.entity
 * @ClassName: User
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-19  16:56
 * @Version: 1.0
 */
@Data
@TableName(value = "user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
