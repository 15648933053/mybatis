package com.starcpdk.mapper;

import com.starcpdk.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据id查询用户
    User getUserById(int id);

    // 分页
    List<User> getUserByLimit(Map<String , Object> map);

    // 分页
    List<User> getUserByRowBounds(Map<String , Object> map);
}

