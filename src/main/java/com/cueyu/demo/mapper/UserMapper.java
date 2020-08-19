package com.cueyu.demo.mapper;

import com.cueyu.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "iscuit", column = "iscuit"),

    })
    User getById(int id);

    @Insert("insert into user(id,username,password,iscuit) values(NULL,#{username},#{password},#{iscuit})")
    int addUser(User user);

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "iscuit", column = "iscuit"),
    })
    User getByname(String name);
}
