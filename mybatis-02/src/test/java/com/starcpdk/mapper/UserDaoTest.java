package com.starcpdk.mapper;

import com.starcpdk.pojo.User;
import com.starcpdk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test() {
        // 获取sqlsession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一 ：  通过getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式二 ：  通过sqlsession
        // List<User> userList1 = sqlSession.selectList("com.starcpdk.dao.UserMapper.getUserList");

        for (User user : userList) {
            System.out.println(user.getId());
        }

        // 关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void testgetUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);

        sqlSession.close();
    }

}
