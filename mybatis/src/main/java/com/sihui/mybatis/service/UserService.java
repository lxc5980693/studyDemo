package com.sihui.mybatis.service;

import com.sihui.mybatis.model.User;
import com.sihui.mybatis.model.UserQuery;

import java.util.List;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.service
 * @ClassName: UserService
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-10-27  15:53
 * @Version: 1.0
 */
public interface UserService {

    int insert(User record);

    List<User> selectAll();

    List<User> selectByQuery(UserQuery userQuery);

}
