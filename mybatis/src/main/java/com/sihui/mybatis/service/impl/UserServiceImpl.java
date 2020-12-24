package com.sihui.mybatis.service.impl;

import com.sihui.mybatis.mapper.UserMapper;
import com.sihui.mybatis.model.User;
import com.sihui.mybatis.model.UserQuery;
import com.sihui.mybatis.queue.AfterTransactService;
import com.sihui.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @ProjectName: mybatis
 * @Package: com.sihui.mybatis.service.impl
 * @ClassName: UserServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-10-27  15:53
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int insert(User record) {
        record = new User();
        record.setName("test_chenguagua");
        record.setAge(60);
        userMapper.insert(record);
        log.info("UserService -> insert user:{}",record.getName());
        if (TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(new AfterTransactService(()->{
                System.out.println("提交之后执行的方法。。。。");
            }));
        }
        User record1 = new User();
        record1.setName("test_liguagua");
        record1.setAge(3);
        userMapper.insert(record1);
        log.info("UserService -> insert user2:{}",record1.getName());
        return 2;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public List<User> selectByQuery(UserQuery userQuery) {
        return null;
    }
}
