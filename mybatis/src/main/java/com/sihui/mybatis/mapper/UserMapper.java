package com.sihui.mybatis.mapper;

import com.sihui.mybatis.model.User;
import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Thu Dec 05 16:23:49 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Thu Dec 05 16:23:49 CST 2019
     */
    List<User> selectAll();
}