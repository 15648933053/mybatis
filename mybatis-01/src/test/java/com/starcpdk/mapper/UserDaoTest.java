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
    public void test(){
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
    public void testgetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testaddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(13 , "怕怕" , "465546");
        int count = userMapper.addUser(user);
        if (count > 0){
            System.out.println("插入成功");
        }

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdateUser(){

        User user = new User(1 , "一份"  , "456486");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int updateUser = userMapper.updateUser(user);
        if (updateUser > 0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int deleteUser = userMapper.deleteUser(1);
        if (deleteUser > 0){
            System.out.println("删除成功");
        }


        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testAddUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String , Object> map = new HashMap<String, Object>();
        map.put("yyfid" , 5);
        map.put("yyfname" , "党浩");
        map.put("yyfpwd" , "1234156");
        int addUserByMap = userMapper.addUserByMap(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.likeSelUser("xcs");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
