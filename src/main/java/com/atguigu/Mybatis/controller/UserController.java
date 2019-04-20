package com.atguigu.Mybatis.controller;

import com.atguigu.Mybatis.Bean.Order;
import com.atguigu.Mybatis.Bean.User;
import com.atguigu.Mybatis.Mapper.OrdersMapper;
import com.atguigu.Mybatis.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrdersMapper ordersMapper;
    //查询
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return ordersMapper.getOrderById(id);
    }
    //查询
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUser(id);
    }
    //插入
    @GetMapping("/user")
    @Transactional      //配置事务，添加@Transactional
    public void insertUser(){
        User user = new User();
        user.setUserName("小芳");
        user.setData(new Date());
        userMapper.insertUser(user);
        if(true){
            throw new RuntimeException("抛出异常");
        }
    }
}
