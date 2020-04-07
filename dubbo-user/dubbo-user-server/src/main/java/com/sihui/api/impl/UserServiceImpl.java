package com.sihui.api.impl;

import com.sihui.api.dto.UserEntity;
import com.sihui.api.entity.TUser;
import com.sihui.api.service.TUserService;
import com.sihui.api.service.UserService;
import com.sihui.dubbo.common.annotation.RpcAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.api.impl
 * @ClassName: UserServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  16:22
 * @Version: 1.0
 */
@RpcAnnotation(UserService.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserService tUserService;

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @Override
    public String getUser(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        TUser tUser = tUserService.queryById(Long.valueOf(id));
//        return new UserEntity(tUser.getId(), tUser.getName(), tUser.getAge(), tUser.getAddress());
        return null;
    }

    /**
     * @param userEntity
     * @Author lixuanchen
     * @Version 1.0
     * @Description 保存用户信息
     * @Return java.lang.Boolean
     * @Exception
     * @Date 2020-04-06  16:32
     */
    @Override
    public Boolean save(UserEntity userEntity) {
        TUser insert = tUserService.insert(new TUser(userEntity.getId(), userEntity.getName(), userEntity.getAge(), userEntity.getAddress()));
        return Objects.isNull(insert.getId()) ? Boolean.FALSE : Boolean.TRUE;
    }
}
