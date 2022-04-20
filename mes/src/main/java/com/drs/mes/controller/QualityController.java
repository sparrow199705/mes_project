package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.service.PlanService;
import com.drs.mes.service.QualityService;
import com.drs.mes.util.DateUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@RestController
@RequestMapping("/admin/quality")
public class QualityController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private QualityService qualityService;

    @Autowired
    PlanService planService;

    @PostMapping(value = "/getFiveSecond", produces = "application/json;charset=UTF-8")
    public String get5Second(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        String [] deviceIds = new String[0];
        String [] materialCodes = new String[0];
        String [] defectiveTypes = new String[0];
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        String defectiveType = post.get("defectiveType").toString();
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        if (!defectiveType.equals("all")){
            defectiveTypes = defectiveType.split(",");
        }
        //获取日良品
        Map<String , Object> qualifiedMap = qualityService.getQualifiedNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes);
        int qualifiedNum = 0;
        int badNum = 0;
        double badRate = 0;
        if (qualifiedMap != null){
            qualifiedNum = Integer.parseInt(qualifiedMap.get("qualifiedNum").toString());
            badNum = Integer.parseInt(qualifiedMap.get("badNum").toString());
            badRate = (float)badNum / ((float)qualifiedNum + (float)badNum) * 100;
        }
        DecimalFormat dfs   = new DecimalFormat("######0.00");//保留两位小数
        badRate = Double.parseDouble(dfs.format(badRate));
        map.put("qualifiedNum" , qualifiedNum);
        map.put("badNum" , badNum);
        map.put("badRate" , badRate);
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getOneMinute", produces = "application/json;charset=UTF-8")
    public String getMonthOutput(@RequestBody Map<String , Object> post) throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        String [] deviceIds = new String[0];
        String [] materialCodes = new String[0];
        String [] defectiveTypes = new String[0];
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        String defectiveType = post.get("defectiveType").toString();
        String dimensionality = post.get("dimensionality").toString();
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        if (!defectiveType.equals("all")){
            defectiveTypes = defectiveType.split(",");
        }
        int badnum=0;
        int outNum=0;
        double badRate = 0;
        List<Map<String , Object>> chartList = new ArrayList<>();
        //日小时级
        if (dimensionality.equals("day")){
            for (int i=0 ; i <=23 ; i++){
                Map<String , Object> chartMap = new HashMap<>();
                String hour;
                if (i<10){
                    hour = "0"+i;
                }else {
                    hour = i+"";
                }
                //获取日不良统计
                badnum=qualityService.getDayBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes ,i);//日小时级不良
                outNum=planService.getHourOutput(deviceId,materialCode ,deviceIds , materialCodes , i); //日小时级产量
                if (badnum != 0){//不良率
                    badRate= new BigDecimal((float)badnum / (badnum+outNum)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue() *100;
                }else {
                    badRate= 0;
                }
                chartMap.put("date" ,hour);
                chartMap.put("badNum" ,badnum);
                chartMap.put("output" ,outNum);
                chartMap.put("badRate" ,badRate);
                chartList.add(chartMap);
            }
        }else if (dimensionality.equals("month")){//月度日级
            List<String> list = DateUtil.getAllTheDateOftheMonth(new Date());
            for(String date: list) {
                Map<String , Object> chartMap = new HashMap<>();
                badnum=qualityService.getMonthBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes,date);//月度日级不良统计
                outNum=planService.getMonthOutput(deviceId,materialCode ,deviceIds , materialCodes ,date);//月度日级产量
                if (badnum != 0){//不良率
                    badRate= new BigDecimal((float)badnum / (badnum+outNum)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue() *100;
                }else {
                    badRate= 0;
                }
                chartMap.put("date" ,date);
                chartMap.put("badNum" ,badnum);
                chartMap.put("output" ,outNum);
                chartMap.put("badRate" ,badRate);
                chartList.add(chartMap);
            }
        }else if (dimensionality.equals("year")){ //年度月级
            List<String> list = DateUtil.getAllTheDateOftheYear(new Date());
            for(String date: list) {
                Map<String , Object> chartMap = new HashMap<>();
                badnum=qualityService.getYearBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes , date);//年度月级不良
                outNum=planService.getYearOutput(deviceId,materialCode,deviceIds,materialCodes,date);//年度月级产量
                if (badnum != 0){//不良率
                    badRate= new BigDecimal((float)badnum / (badnum+outNum)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue() *100;
                }else {
                    badRate= 0;
                }
                chartMap.put("date" ,date);
                chartMap.put("badNum" ,badnum);
                chartMap.put("output" ,outNum);
                chartMap.put("badRate" ,badRate);
                chartList.add(chartMap);
            }
        }
        map.put("chart" , chartList);//趋势图
        //产品不良分类
        List<Map<String , Object>> badType = qualityService.getBadTypeNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes ,dimensionality);
        map.put("badType" , badType);
        //电流均值分布图
        List<Map<String , Object>> electricity = qualityService.getElectricity(deviceId,deviceIds);
        map.put("electricity" , electricity);
        //高不良率TOP10
        List<Map<String , Object>> badTop10 = qualityService.getBadTop10();
        map.put("badTop10" , badTop10);
        //质量预警
        map.put("warning" ,qualityService.getWarning());
        //焊接点电流控制图
        List<Map<String , Object>> controller1 = planService.getControllerI("1");
        List<Map<String , Object>> controller2 = planService.getControllerI("2");
        map.put("controller1" ,controller1);
        map.put("controller2" ,controller2);
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }



}
