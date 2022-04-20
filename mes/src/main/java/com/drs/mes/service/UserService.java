package com.drs.mes.service;

import com.drs.mes.Pojo.ParamSet;
import com.drs.mes.Pojo.User;
import com.drs.mes.mapper.mesBase.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    //登录
    public User userLogin(User user) {
        return  userMapper.userLogin(user);
    }

    //注册
    public User findUserByAccount(String account ,String mobile){
        return userMapper.findUserByAccount(account , mobile);
    }
    public void addUser(User user){
        userMapper.addUser(user);
    }

    //修改
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    public int getUserListTotal(String searchKey , String search){
        return userMapper.getUserListTotal(searchKey ,search );
    }

    //获取用户信息
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    //获取参数设置
    public List<ParamSet> getParamList(){
        return userMapper.getParamList();
    }

    //修改参数设置
    public void updateParam(ParamSet paramSet){
        userMapper.updateParam(paramSet);
    }
    //获取用户信息
    public Map<String , Object> getUserInfo(int id){
        return userMapper.getUserInfo(id);
    }
    //获取用户列表
    public List<Map<String , Object>> getUserList(String searchKey , String search , int page){
        return userMapper.getUserList(searchKey ,search ,page);
    }
}
