package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.*;
import com.drs.mes.service.ReportService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/report")
public class ReportController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;


    //获取生产产量列表
    @PostMapping(value = "/getProductionList", produces = "application/json;charset=UTF-8")
    public String getProductionList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") >0){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<StatisticalProductionList> productionList = reportService.getProductionList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString(),(Integer)post.get("hour") ,
                post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , productionList);
        map.put("total" , reportService.getProductionTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString(),(Integer)post.get("hour"),
                post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取生产产能列表
    @PostMapping(value = "/getCapacityList", produces = "application/json;charset=UTF-8")
    public String getCapacityList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<StatisticalCapacity> capacityList = reportService.getCapacityList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString(),page);
        map.put("data" , capacityList);
        map.put("total" , reportService.getCapacityTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取生产不良列表
    @PostMapping(value = "/getBadProductionList", produces = "application/json;charset=UTF-8")
    public String getBadProductionList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<StatisticalBadProduction> badProductionList = reportService.getBadProductionList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString(),(Integer)post.get("hour") ,
                post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , badProductionList);
        map.put("total" , reportService.getBadProductionTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("materialCode").toString(),post.get("materialName").toString(),(Integer)post.get("hour") ,
                post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取设备参数列表
    @PostMapping(value = "/getParameterList", produces = "application/json;charset=UTF-8")
    public String getParameterList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<Map<String ,Object>> deviceParameterList = reportService.getParameterList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , deviceParameterList);
        map.put("total" , reportService.getParameterTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取设备能耗列表
    @PostMapping(value = "/getEnergyList", produces = "application/json;charset=UTF-8")
    public String getEnergyList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<Map<String , Object>> EnergyList = reportService.getEnergyList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                (Integer)post.get("hour"),post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , EnergyList);
        map.put("total" , reportService.getEnergyTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                (Integer)post.get("hour"),post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //获取OEE列表
    @PostMapping(value = "/getOEEList", produces = "application/json;charset=UTF-8")
    public String getOEEList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") > 0){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<Map<String , Object>> oeeList = reportService.getOEEList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , oeeList);
        map.put("total" , reportService.getOEEListTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }
}
