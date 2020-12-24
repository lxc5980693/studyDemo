package com.sihui.mybatis.mapper;

import com.sihui.mybatis.model.User;
import com.sihui.mybatis.model.UserQuery;

import java.util.List;

public interface UserMapper {

    int insert(User record);

    List<User> selectAll();

    List<User> selectByQuery(UserQuery userQuery);
}