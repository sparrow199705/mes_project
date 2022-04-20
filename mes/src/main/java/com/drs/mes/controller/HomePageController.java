package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.drs.mes.service.HomePageService;
import com.drs.mes.service.PlanService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/home")
public class HomePageController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);
    DecimalFormat    dfs   = new DecimalFormat("######0.00");//保留两位小数
    @Autowired
    private HomePageService homeService;

    @Autowired
    private PlanService planService;


    @PostMapping(value = "/getFiveSecond", produces = "application/json;charset=UTF-8")
    public String getFiveSecond(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        //月产量
        List<Map<String , Object>> mothOutput = homeService.getMothOutput();
        List<Map<String , Object>> outputList = new ArrayList<>();
        for (Map<String , Object> outputMap : mothOutput){
            //获取日产量
            outputMap.put("dayOutput" , homeService.getDayOutputByM(outputMap.get("materialName").toString()));
            outputList.add(outputMap);
        }
        map.put("output" , mothOutput);
        //设备OEE
        double OEE = homeService.getOEE();
        OEE = Double.parseDouble(dfs.format(OEE * 100));
        map.put("OEE" ,OEE);


        //产品合格率
        int badOutput = homeService.getAllBadOutput();
        int allDayOutput = homeService.getAllDayOutput();
        float percent = (float) 0.00;
        if (allDayOutput != 0){
            percent =  (float)allDayOutput / ( (float)badOutput +  (float)allDayOutput) * 100;
        }
        BigDecimal b = new BigDecimal(percent);
        percent = b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        map.put("percentOfPass" , percent);

        //计划完成率
        int dayOutput = planService.getAllDayOutput("all","all" ,null , null);        //日总产量
        //标准小时产能
        List<Map<String , Object>> capacity = planService.getCapacity("all","all" ,null , null);        //日总产量
        //计划小时产能
        List<Map<String , Object>> planCapacity = planService.getPlanCapacity("all","all" ,null , null);        //日总产量
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
        float finish = (float) 0.00;
        if (dayOutput != 0){
            finish = (float)dayOutput / ((float)capacityInt * 24) * 100;
        }
        BigDecimal b1 = new BigDecimal(finish);
        finish = b1.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        map.put("finish" , finish);

        //总设备数
        int deviceNum = homeService.getDeviceNum();
        List<Map<String , Object>> onlineDeviceList = homeService.getOnlineDevice();
        int run = 0 ; //运行
        int pause = 0; //暂停
        int standby = 0;//待机
        int off = 0; //离线
        for (Map<String , Object> onlineDeviceMap : onlineDeviceList){
            String state = onlineDeviceMap.get("state").toString();
            if (state.equals("运行")){
                run = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }else if (state.equals("暂停")){
                pause = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }else if (state.equals("待机")){
                standby = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }
        }
        off =(deviceNum - run - pause - standby);
        map.put("deviceNum" , deviceNum);
        map.put("deviceRun" , run);
        map.put("devicePause" , pause);
        map.put("deviceStandby" , standby);
        map.put("deviceOff" , off);

        //设备状态
        List<Map<String , Object>> deviceState = new ArrayList<>();
        List<Map<String , Object>> deviceList = homeService.getAllDevice();
        String state = null;
        /******************计划完成率****************/
        for (Map<String ,Object> deviceMap : deviceList){
            String[] devices={deviceMap.get("deviceId").toString()};
            int dayOutput1 = planService.getAllDayOutput(deviceMap.get("deviceId").toString(),"all" ,devices , null);        //日总产量
            //标准小时产能
            List<Map<String , Object>> capacity1 = planService.getCapacity(deviceMap.get("deviceId").toString(),"all" ,devices , null);
            //计划小时产能
            List<Map<String , Object>> planCapacity1 = planService.getPlanCapacity(deviceMap.get("deviceId").toString(),"all" ,devices , null);
            capacity1.addAll(planCapacity1);
            List<Map<String,Object>> result1 = capacity1.stream()
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
            int capacityInt1 = 0;
            for (Map<String , Object> cap : result1){
                capacityInt1 += (Integer) cap.get("capacity");
            }
            float finish1 = 0;
            if (dayOutput1 != 0){
                finish1 = (float)dayOutput1 / ((float)capacityInt1 * 24) * 100;
            }
            BigDecimal b2 = new BigDecimal(finish1);
            finish1 = b2.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            deviceMap.put("finish" ,finish1 );
           /******************计划完成率****************/

            //设备OEE
            double deviceOEE = homeService.getOEEByD(deviceMap.get("deviceId").toString());
            deviceOEE = Double.parseDouble(dfs.format(deviceOEE * 100));
            deviceMap.put("OEE" , deviceOEE);
            //合格率
            float pass = (float) 0.00;
            int deviceBad = homeService.getBadByD(deviceMap.get("deviceId").toString());
            if (dayOutput1 != 0){
                pass = (float)dayOutput1 / ((float)deviceBad+(float)dayOutput1) *100;
            }
            BigDecimal b3 = new BigDecimal(pass);
            pass = b3.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
            deviceMap.put("pass" , pass);
            //状态
            state = homeService.getDeviceState(deviceMap.get("deviceId").toString());
            if (state == null){
                state="离线";
            }
            deviceMap.put("state" ,state );
            deviceState.add(deviceMap);
        }
        map.put("deviceState" , deviceState);
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getOneMinute", produces = "application/json;charset=UTF-8")
    public String getOneMinute(@RequestBody Map<String , Object> post) throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        //实时能耗
        List<Map<String , Object>> mapList  = homeService.getTimeEP();
        //单位能耗
        List<Map<String , Object>> unitEPList = new ArrayList<>();

        for (Map<String , Object> unitEPMap : mapList){
            int badOutput = homeService.getBadByD(unitEPMap.get("deviceId").toString());
            int allDayOutput = homeService.getOutputByD(unitEPMap.get("deviceId").toString());
            double unitEP = (double) unitEPMap.get("ep");
            double unitEPDouble = 0.0000;
            if (unitEP != 0 && badOutput + allDayOutput != 0){
                unitEPDouble = unitEP / ( badOutput + allDayOutput);
            }
            unitEPMap.put("unitEP" , unitEPDouble);
            unitEPList.add(unitEPMap);
        }
        map.put("unitEP" , unitEPList);
        //日产品不良
        List<Map<String , Object>> badList = homeService.getBadOutput();
        map.put("bad" , badList);
        //报警分类统计
        List<Map<String , Object>> alarmType = homeService.getAlarmType();
        map.put("alarmType" , alarmType);
        //预警分类统计
        List<Map<String , Object>> warningType = homeService.getWarningType();
        map.put("warningType" , warningType);
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull, SerializerFeature.DisableCircularReferenceDetect);
        map.clear();
        return json;
    }

}
