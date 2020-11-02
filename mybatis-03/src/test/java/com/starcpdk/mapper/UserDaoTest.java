package com.starcpdk.mapper;

import com.starcpdk.pojo.User;
import com.starcpdk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testgetUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(2);
        System.out.println(user);

        sqlSession.close();
    }
}
