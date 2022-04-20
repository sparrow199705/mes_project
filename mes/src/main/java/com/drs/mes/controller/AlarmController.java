package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.FuzzySearch;
import com.drs.mes.Pojo.StatisticalDeviceAlarm;
import com.drs.mes.Pojo.StatisticalProduction;
import com.drs.mes.Pojo.StatisticalProductionEarlyWarning;
import com.drs.mes.service.AlarmService;
import com.drs.mes.service.ReportService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/alarm")
public class AlarmController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(AlarmController.class);

    @Autowired
    private AlarmService alarmService;

    //获取设备告警统计列表
    @PostMapping(value = "/getAlarmList", produces = "application/json;charset=UTF-8")
    public String getAlarmList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<StatisticalDeviceAlarm> alarmList = alarmService.getAlarmList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("alarmType").toString(),(Integer)post.get("hour") ,
                post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , alarmList);
        map.put("total" , alarmService.getAlarmTotal(post.get("deviceId").toString() , post.get("deviceName").toString(),
                post.get("alarmType").toString(),(Integer)post.get("hour") ,
                post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //告警明细
    @PostMapping(value = "/getDetailList", produces = "application/json;charset=UTF-8")
    public String getDetailList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<Map<String, Object>> detailList = alarmService.getDetailList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("alarmDescription").toString() , post.get("alarmType").toString(),post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , detailList);
        map.put("total" , alarmService.getDetailTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("alarmDescription").toString() , post.get("alarmType").toString(),post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //获取生产预警
    @PostMapping(value = "/getWarningList", produces = "application/json;charset=UTF-8")
    public String getWarningList(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int page = 0;
        if ((Integer)post.get("page") != -1){
            page =((Integer)post.get("page")-1)*10;
        }else {
            page = -1;
        }
        List<StatisticalProductionEarlyWarning> alarmList = alarmService.getWarningList(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("warningType").toString() , post.get("warningInfo").toString(),post.get("startTime").toString(),post.get("endTime").toString(),page);
        map.put("data" , alarmList);
        map.put("total" , alarmService.getWarningTotal(post.get("deviceId").toString(),post.get("deviceName").toString(),
                post.get("warningType").toString() , post.get("warningInfo").toString(),post.get("startTime").toString(),post.get("endTime").toString()));
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //查询框模糊查询
    @PostMapping(value = "/SearchDetail", produces = "application/json;charset=UTF-8")
    public String fuzzySearch(@RequestBody FuzzySearch fuzzySearch, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        List<String> data = alarmService.SearchDetail(fuzzySearch.getSearchKey() , fuzzySearch.getSearch());
        map.put("data" , data);
        code = 200;
        msg="获取成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }



}
