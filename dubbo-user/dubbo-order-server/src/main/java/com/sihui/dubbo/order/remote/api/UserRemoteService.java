package com.sihui.dubbo.order.remote.api;

import com.sihui.api.dto.UserEntity;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.dubbo.order.remote.api
 * @ClassName: UserService
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:52
 * @Version: 1.0
 */
public interface UserRemoteService {
    UserEntity getUser(Long id);
}
