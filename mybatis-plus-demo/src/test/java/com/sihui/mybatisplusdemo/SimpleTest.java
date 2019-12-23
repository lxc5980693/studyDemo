package com.sihui.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.sihui.mybatisplusdemo.entity.User;
import com.sihui.mybatisplusdemo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo
 * @ClassName: SimpleTest
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-19  17:00
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select(){
        List<User> users = userMapper.selectList(new Wrapper<User>() {
            @Override
            public User getEntity() {
                User user = new User();
                user.setName("Jone");
                return user;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        });
        Assert.assertEquals(1, users.size());
        users.forEach(System.out::println);
    }
}
