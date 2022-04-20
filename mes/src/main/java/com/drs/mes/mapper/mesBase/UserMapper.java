package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.ParamSet;
import com.drs.mes.Pojo.User;
import org.openxmlformats.schemas.presentationml.x2006.main.STIndex;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    //登录
    User userLogin (User user);

    //注册
    User findUserByAccount(String account ,String mobile);
    void addUser(User user);

    //修改
    void updateUser(User user);

    //获取用户列表
    List<Map<String , Object>> getUserList(String searchKey , String search , int page);
    int getUserListTotal(String searchKey , String search);

    //获取用户信息
    User getUserById(int id);

    //获取参数设置
    List<ParamSet> getParamList();

    //修改参数设置
    void updateParam(ParamSet paramSet);
    //获取用户信息
    Map<String , Object> getUserInfo(int id);
}
