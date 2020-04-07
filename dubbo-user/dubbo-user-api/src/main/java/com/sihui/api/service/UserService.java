package com.sihui.api.service;

import com.sihui.api.dto.UserEntity;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.api.service
 * @ClassName: UserService
 * @Author: lixuanchen
 * @Description: 用户接口
 * @Date: 2020-03-02  22:56
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 查询用户
     * @param id
     * @return
     */
    String getUser(String id);

    /**
     *  @Author  lixuanchen
     *  @Version    1.0
     *  @Description    保存用户信息
     *  @Return  java.lang.Boolean
     *  @Exception
     *  @Date  2020-04-06  16:32
     *  @param userEntity
     */
    Boolean save(UserEntity userEntity);

}
