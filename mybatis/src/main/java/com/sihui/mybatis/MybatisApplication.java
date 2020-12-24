package com.sihui.mybatis;

import com.sihui.mybatis.mapper.UserMapper;
import com.sihui.mybatis.model.User;
import com.sihui.mybatis.model.UserQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

public class MybatisApplication {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(ExecutorType.SIMPLE);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQuery userQuery = new UserQuery();
        userQuery.setId(1);
        List<User> users = mapper.selectByQuery(userQuery);
        System.out.println(users.toString());
        MybatisApplication mybatisApplication = new MybatisApplication() ;
        mybatisApplication.test();
    }

    public void test(){
        System.out.println(getClass().getSimpleName().toLowerCase(Locale.ENGLISH));
    }

}
