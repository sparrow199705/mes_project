package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.ParamSet;
import com.drs.mes.Pojo.User;
import com.drs.mes.service.UserService;
import com.drs.mes.util.MD5util;
import com.drs.mes.util.TokenUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController{


    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    //用户登录
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestBody User userLogin) {
        Map<String , Object> map  = new HashMap<>();
        //MD5加密
        userLogin.setPassword(MD5util.getMD5Str(userLogin.getPassword()));
        User user =userService.userLogin(userLogin);
        if (user != null){
            flag=true;
            msg = "登录成功";
            map.put("token" , TokenUtil.sign(String.valueOf(user.getId())));
            map.put("user" , user);
            code = 200;
        }else {
            flag=false;
            msg = "登录失败,账号密码错误";
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //注册
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public String register(@RequestBody Map<String , Object> post) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String password = post.get("password").toString();
        String againpassword = post.get("againpassword").toString();
        String account = post.get("account").toString();
        String nickname = post.get("nickname").toString();
        String mobile = post.get("mobile").toString();
        User isUser = userService.findUserByAccount(account , mobile);
        if (isUser == null){//是否重复注册
            if (password.equals(againpassword)){//密码是否相同
                password = MD5util.getMD5Str(password);
                String userId = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
                User user = new User();
                user.setAccount(account);
                user.setMobile(mobile);
                user.setPassword(password);
                user.setNickname(nickname);
                user.setAddtime(df.format(new Date()));
                user.setUpdatetime(df.format(new Date()));
                user.setUserId(userId);
                userService.addUser(user);
                flag=true;
                msg="注册成功!";
                code = 200;
            }else {
                flag=false;
                msg = "密码不相同，请重新输入！";
            }
            String json = JSON.toJSONString(ResState(flag , msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        }else {
            msg = "账号或手机号已被注册!";
            String json = JSON.toJSONString(ResState(false, msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        }
    }

    //修改用户信息
    @PostMapping(value = "/updateUser", produces = "application/json;charset=UTF-8")
    public String updateUser(@RequestBody Map<String , Object> post , HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
        if (userId ==1 || userId==(int) post.get("id")){
            User user =new User();
            user.setUserId(post.get("userId").toString());
            user.setPassword(MD5util.getMD5Str(post.get("password").toString()));
            user.setNickname(post.get("nickname").toString());
            user.setMobile(post.get("mobile").toString());
            userService.updateUser(user);
            flag=true;
            code = 200;
            msg="修改成功!";
            String json = JSON.toJSONString(ResState(true, msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        }else {
            msg="无此权限!";
            String json = JSON.toJSONString(ResState(false, msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        }

    }

    //获取用户列表
    @PostMapping(value = "/getUserList", produces = "application/json;charset=UTF-8")
    public String getUserList(@RequestBody Map<String , Object> post ,HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
        if (userId ==1){
            List<Map<String , Object>> userList = userService.getUserList(post.get("searchKey").toString() ,
                    post.get("search").toString() , ((int)post.get("page")-1)*10);
            map.put("total" , userService.getUserListTotal(post.get("searchKey").toString() ,
                    post.get("search").toString()) );
            map.put("data" , userList);
            msg="获取成功!";
            code = 200;
            String json = JSON.toJSONString(ResState(true, msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        }else {
            msg="无此权限!";
            String json = JSON.toJSONString(ResState(false, msg , map ,code),allowJsonNull,datetimeformat);
            map.clear();
            return json;
        } 
    }

    //获取参数设置列表
    @PostMapping(value = "/getParamList", produces = "application/json;charset=UTF-8")
    public String getParamList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        List<ParamSet> paramSetList = userService.getParamList();
        map.put("data" , paramSetList);
        msg="获取成功!";
        code = 200;
        String json = JSON.toJSONString(ResState(true, msg , map ,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //修改参数设置
    @PostMapping(value = "/updateParam", produces = "application/json;charset=UTF-8")
    public String updateParam(@RequestBody List<ParamSet> paramSets) {
        Map<String,Object> map = new HashMap<>();
        for (ParamSet paramSet : paramSets){
            userService.updateParam(paramSet);
        }
        msg="修改成功!";
        code = 200;
        String json = JSON.toJSONString(ResState(true, msg , map ,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //获取用户信息
    @PostMapping(value = "/getUserInfo", produces = "application/json;charset=UTF-8")
    public String getUserInfo( HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int id = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
        Map<String , Object> user = userService.getUserInfo(id);
        map.put("user" , user);
        msg="获取成功!";
        code = 200;
        String json = JSON.toJSONString(ResState(true, msg , map ,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

}
