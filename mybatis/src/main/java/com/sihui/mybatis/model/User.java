package com.sihui.mybatis.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends UserBase {
    private Integer age;
}