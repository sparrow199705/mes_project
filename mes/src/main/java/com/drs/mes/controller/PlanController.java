package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/plan")
public class PlanController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private PlanService planService;

    @Autowired
    private QualityService qualityService;



    @PostMapping(value = "/getDimensionality", produces = "application/json;charset=UTF-8")
    public String getDimensionality(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        List<Map<String , Object>> deviceList;//
        if (post.containsKey("materialCode") && post.get("materialCode")!= null && post.get("materialCode")!=""){
            String[] materialCodes = post.get("materialCode").toString().split(",");
            deviceList = planService.getDeviceByMaterial(materialCodes);
        }else {
            deviceList = planService.getDevice();
        }
        List<Map<String , Object>> materialList = planService.getMaterial();
        List<Map<String , Object>> badTypeList = qualityService.badType();
        map.put("deviceList" ,deviceList);
        map.put("materialList" ,materialList);
        map.put("badTypeList" ,badTypeList);
        String json = JSON.toJSONString(ResState(true,msg,map,200),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getFiveSecond", produces = "application/json;charset=UTF-8")
    public String get5Second(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        String [] deviceIds = new String[0];
        String [] materialCodes = new String[0];
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        //获取日产量
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        int dayOutput = planService.getAllDayOutput(deviceId,materialCode ,deviceIds , materialCodes);
        map.put("dayOutput" , dayOutput);
        //平均小时产量
        double AVGOutput = planService.getAVGOutput(deviceId,materialCode ,deviceIds , materialCodes);
        map.put("AVGOutput" , AVGOutput);
        //日估产量
        double estimationOutput = AVGOutput * 24;
        map.put("estimationOutput" , estimationOutput);
        //标准小时产能
        List<Map<String , Object>> capacity = planService.getCapacity(deviceId,materialCode ,deviceIds , materialCodes);
        //计划小时产能
        List<Map<String , Object>> planCapacity = planService.getPlanCapacity(deviceId,materialCode ,deviceIds , materialCodes);
        capacity.addAll(planCapacity);
        List<Map<String,Object>> result = capacity.stream()
                .collect(Collectors.groupingBy(group -> group.get("dmid").toString()))//根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
                .entrySet()//得到Set<Map.Entry<String, List<Map<String, Object>>>
                .stream()
                .map(map1 -> {
                    Map<String,Object> collect = map1.getValue().stream()//m.getValue()的结果是 List<Map<String, Object>>
                            .flatMap(o -> o.entrySet().stream())//o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(m1,m2) -> m2));//(m1, m2) -> m2 的意思是如果 m1 == m2 则使用m2
                    return collect;
                })
                .collect(Collectors.toList());
        int capacityInt = 0;
        for (Map<String , Object> cap : result){
            capacityInt += (Integer) cap.get("capacity");
        }
        map.put("capacity" , capacityInt);
        //计划完成率
        float finish = (float)0.000;
        if (dayOutput != 0){
            finish = (float) dayOutput / ((float)capacityInt * 24) * 100;
        }
        BigDecimal b1 = new BigDecimal(finish);
        finish = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        map.put("finish" , finish);

        code = 200;
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
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        String dimensionality = post.get("dimensionality").toString();
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        List<Map<String , Object>> outputList = new ArrayList<>();
        String hour;

        //标准小时产能
        List<Map<String , Object>> capacity = planService.getCapacity(deviceId,materialCode ,deviceIds , materialCodes);
        //计划小时产能
        List<Map<String , Object>> planCapacity = planService.getPlanCapacity(deviceId,materialCode ,deviceIds , materialCodes);
        capacity.addAll(planCapacity);
        List<Map<String,Object>> result = capacity.stream()
                .collect(Collectors.groupingBy(group -> group.get("dmid").toString()))//根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
                .entrySet()//得到Set<Map.Entry<String, List<Map<String, Object>>>
                .stream()
                .map(map1 -> {
                    Map<String,Object> collect = map1.getValue().stream()//m.getValue()的结果是 List<Map<String, Object>>
                            .flatMap(o -> o.entrySet().stream())//o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(m1,m2) -> m2));//(m1, m2) -> m2 的意思是如果 m1 == m2 则使用m2
                    return collect;
                })
                .collect(Collectors.toList());
        int capacityInt = 0;
        for (Map<String , Object> cap : result){
            capacityInt += (Integer) cap.get("capacity");
        }



        if (dimensionality.equals("day")){ //日小时级
            for (int i=0 ; i <=23 ; i++){
                Map<String , Object> outputStat = new HashMap<>();
                hour = i+"";
                //日小时级产量
                outputStat.put("date" , hour);
                int dayOutput = planService.getHourOutput(deviceId,materialCode ,deviceIds , materialCodes , i);
                outputStat.put("output" , dayOutput);
                float finish = (float) 0.00;
                if (dayOutput != 0){
                    finish = (float)dayOutput / (float)capacityInt * 100;
                }
                BigDecimal b1 = new BigDecimal(finish);
                finish = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
                outputStat.put("finish" , finish);
                outputList.add(outputStat);
                System.out.println(outputStat);
                System.out.println(outputList);
                }
        }else if (dimensionality.equals("month")){// 月度日级
            List<String> list = DateUtil.getAllTheDateOftheMonth(new Date());
            for(String date: list) {
                Map<String , Object> outputStat = new HashMap<>();
                //月度日级产量
                outputStat.put("date" , date);
                int dayOutput = planService.getMonthOutput(deviceId,materialCode ,deviceIds , materialCodes ,date);
                outputStat.put("output" , dayOutput);
                float finish = 0;
                if (dayOutput != 0){
                    finish = (float)dayOutput / ((float)capacityInt *24 ) * 100;
                }
                BigDecimal b1 = new BigDecimal(finish);
                finish = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
                outputStat.put("finish" , finish);
                outputList.add(outputStat);
            }
        }else if (dimensionality.equals("year")){ //年度月级
            List<String> list = DateUtil.getAllTheDateOftheYear(new Date());
            for(String date: list) {
                Map<String , Object> outputStat = new HashMap<>();
                //年度月级产量
                outputStat.put("date" , date);
                int dayOutput = planService.getYearOutput(deviceId,materialCode,deviceIds,materialCodes,date);
                outputStat.put("output" , dayOutput);
                float finish = (float) 0.00;
                if (dayOutput != 0){
                    finish = (float)dayOutput / ((float)capacityInt *24 * 30) * 100;
                }
                BigDecimal b1 = new BigDecimal(finish);
                finish = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
                outputStat.put("finish" , finish);
                outputList.add(outputStat);
            }
        }
        List<Map<String , Object>> OEEList = planService.getLowOEE();
        List<Map<String , Object>> OEELow = new ArrayList<>();
        for (Map<String , Object> OEEMap : OEEList){
            int badoutput= Integer.parseInt(OEEMap.get("badoutput").toString());
            int output= Integer.parseInt(OEEMap.get("output").toString());
            float badRate = (float) 0.00;
            if (badoutput != 0){
                badRate = (float)badoutput / ((float)badoutput + output);
            }
            BigDecimal b1 = new BigDecimal(badRate);
            badRate = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            OEEMap.put("badRate" , badRate);
            OEEMap.put("estimationOutput" ,  Double.parseDouble(OEEMap.get("actualSpeed").toString()) * 24 * 60);
            OEELow.add(OEEMap);
        }
        map.put("OEELowTop10" ,OEELow);
        map.put("chart" , outputList);
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull, SerializerFeature.DisableCircularReferenceDetect);
        map.clear();
        return json;
    }

}
