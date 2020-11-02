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

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testgetUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(2);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j的方法了");
        logger.debug("debug:进入了testLog4j的方法了");
        logger.error("error:进入了testLog4j的方法了");
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex" , 0);
        map.put("pageSize" , 2);
        List<User> userByLimit = userMapper.getUserByLimit(map);
        System.out.println(userByLimit);

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 2);

        // 通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.starcpdk.mapper.UserMapper.getUserByRowBounds" , null , rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
