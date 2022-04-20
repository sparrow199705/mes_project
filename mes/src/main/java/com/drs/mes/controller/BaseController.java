package com.drs.mes.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
//    protected int pageSize=10;
//    protected int currnPage=1;
    protected int code=200;
    protected boolean flag = true;
    protected String msg = "";

    protected SerializerFeature allowJsonNull = SerializerFeature.WriteMapNullValue;
    protected SerializerFeature datetimeformat =   SerializerFeature.WriteDateUseDateFormat;

    public Map<String,Object> ResState(boolean flag , String msg ,Map<String,Object> data , int code){
        Map<String ,Object> jsonMap = new HashMap<>();
        jsonMap.put("msg",msg);
        jsonMap.put("success",flag);
        jsonMap.put("code",code);
        jsonMap.putAll(data);
        return jsonMap;
    }
}
