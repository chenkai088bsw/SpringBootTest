package com.atguigu.Mybatis.Mapper;

import com.atguigu.Mybatis.Bean.User;
import org.apache.ibatis.annotations.*;

//注解版本
//指定这是一个操作数据库的mapper
@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User getUser(Integer id);
    @Delete("delete from user where id=#{id}")
    public int delelteUserById(Integer id);
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void insertUser(User user);
    @Update("update user set username=#{username} where id=#{id}")
    public int updateUser(User user);
}













