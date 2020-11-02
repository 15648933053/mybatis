package com.starcpdk.mapper;

import com.starcpdk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 获取全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 插入用户    //  增删改需要提交事务
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);

}

