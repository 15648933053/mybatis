package com.starcpdk.mapper;

import com.starcpdk.pojo.User;
import com.starcpdk.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
/*
        // 查询全部
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
*/

/*
        // 根据id查询
        User userById = userMapper.getUserById(2);
        System.out.println(userById);
*/

/*
        // 添加用户
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPassword("root");
        userMapper.addUser(user);
*/

/*
        // 修改用户
        User user = new User(1, "name", "123456");
        userMapper.updateUser(user);
*/

        // 删除用户
        userMapper.deleteUser(1);

        sqlSession.close();
    }
}
