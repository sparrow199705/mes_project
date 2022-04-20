package com.drs.mes.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.drs.mes.result.CommonResult;
import com.drs.mes.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {



    //无redis情况  re_token = token 跳过重复登录判断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入拦截
        System.out.println("进入拦截");
        //返回数据格式
        response.setContentType("application/json;charset=UTF-8");
        //获取请求头的token
        String token = request.getHeader("token");
        System.out.println("token："+token);
        //判断token是否有效
        if (token !=null){
            String tokenStr = TokenUtil.verify(token);
            int id = 0;
            if (tokenStr != null && tokenStr != ""){
                id = Integer.parseInt(TokenUtil.verify(token));
            }
            if (id>0) {
                //获取token中的用户名
                boolean is_token = true;
                System.out.println("是否存在："+is_token);
                if (is_token) {
                    //获取redis中该用户的token
                    String re_token = token;
//                System.out.println("re_token:"+re_token);
                    if (re_token.equals(token)) {
                        return true;
                    }else {
                        PrintWriter out;
                        out = response.getWriter();
                        out.append(JSON.parseObject(JSON.toJSONString(new CommonResult(202,"账号在其他途径登录")), JSONObject.class).toString());
                        return false;
                    }
                }else {
                    PrintWriter out;
                    out = response.getWriter();
                    out.append(JSON.parseObject(JSON.toJSONString(new CommonResult(201,"登录信息超时，请重新登录")), JSONObject.class).toString());
                    return false;
                }
            }else {
                PrintWriter out;
                out = response.getWriter();
                out.append(JSON.parseObject(JSON.toJSONString(new CommonResult(201,"登录信息超时，请重新登录")), JSONObject.class).toString());
                return false;
            }
        }else {
            System.out.println("空");
            PrintWriter out;
            out = response.getWriter();
            out.append(JSON.parseObject(JSON.toJSONString(new CommonResult(500,"token不能为空")), JSONObject.class).toString());
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
