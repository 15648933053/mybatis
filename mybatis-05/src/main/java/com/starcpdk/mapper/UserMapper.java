package com.starcpdk.mapper;

import com.starcpdk.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    // 方法存在多个参数 ， 所有的参数前面必须加上 @Param  sql语句中的参数名字和@Param注解中的值要保持一致
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    // 引用类型不需要@Param
    @Insert("insert into user() values(#{id} , #{name} , #{password})")
    int addUser(User user);

    @Update("update user set name = #{name} , pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}

