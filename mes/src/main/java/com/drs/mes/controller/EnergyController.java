package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.drs.mes.service.EnergyService;
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

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.drs.mes.util.DateUtil.getDaysOfMonth;

@RestController
@RequestMapping("/admin/energy")
public class EnergyController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(EnergyController.class);

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    @Autowired
    EnergyService energyService;

    @Autowired
    PlanService planService;

    @Autowired
    QualityService qualityService;

    @PostMapping(value = "/getFiveSecond", produces = "application/json;charset=UTF-8")
    public String get5Second(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        String [] deviceIds = new String[0];
        String [] materialCodes = new String[0];
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        //获取日实时能耗
        double dayEP = energyService.getDayEP(deviceId,materialCode ,deviceIds , materialCodes);
        map.put("dayEP" , dayEP);
        //平均小时能耗
        double averageEP = energyService.getAverageEP(deviceId,materialCode ,deviceIds , materialCodes);
        map.put("AVGOutput" , averageEP);
        //标准小时能耗
        map.put("capacity" , energyService.getCapacity(deviceId,materialCode ,deviceIds , materialCodes));
        //获取日产量
        int dayOutput = planService.getAllDayOutput(deviceId,materialCode ,deviceIds , materialCodes);
        map.put("dayOutput" , dayOutput);
        //单位能耗
        double unitEnergy = 0.00000;
        if (averageEP != 0){
            unitEnergy = dayEP/(double) dayOutput;
        }
        DecimalFormat dfs   = new DecimalFormat("######0.00000");//保留两位小数
        unitEnergy = Double.parseDouble(dfs.format(unitEnergy));
        map.put("unitEnergy" , unitEnergy);
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getOneMinute", produces = "application/json;charset=UTF-8")
    public String getOneMinute(@RequestBody Map<String , Object> post) throws InterruptedException, ParseException {
        Map<String,Object> map = new HashMap<>();
        /**********趋势图***********/
        List<Map<String , Object>> energyDeviceList = new ArrayList<>();
        List<Map<String , Object>> energyUnitList = new ArrayList<>();
        String [] deviceIds = new String[0];
        String [] materialCodes = new String[0];
        String deviceId = post.get("deviceId").toString();
        String materialCode = post.get("materialCode").toString();
        String dimensionality = post.get("dimensionality").toString();
        String defectiveType = "all";
        String [] defectiveTypes = null;
        if (!deviceId.equals("all")){
            deviceIds = deviceId.split(",");
        }
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }

        double getEnergyHour= 0;
        int getHourOutput=0;
        int getDayBadNum=0;
        DecimalFormat dfs   = new DecimalFormat("######0.00000");//保留两位小数
        double standard = energyService.getCapacity(deviceId,materialCode ,deviceIds , materialCodes);
        if (dimensionality.equals("day")){//日小时级
            for (int i=0 ; i <=23 ; i++){
                Map<String , Object> energyStat = new HashMap<>();
                Map<String , Object> unitEnergy = new HashMap<>();
                String hour= i+"";
                getEnergyHour = energyService.getEnergyHour(deviceId, materialCode, deviceIds, materialCodes ,i );
                getHourOutput = planService.getHourOutput(deviceId,materialCode ,deviceIds , materialCodes , i);
                getDayBadNum = qualityService.getDayBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes ,i);
                energyStat.put("date" , hour);
                energyStat.put("energy" , getEnergyHour);//日小时级设备能耗统计
                energyStat.put("standard" , standard);//标准能耗
                energyDeviceList.add(energyStat);
                unitEnergy.put("date" , hour);
                unitEnergy.put("output" , getHourOutput);  //日小时级产量
                unitEnergy.put("bad" , getDayBadNum);//获取日不良统计
                double unit = 0.00000;//获取日小时级单位能耗统计
                if (getHourOutput+getDayBadNum !=0){
                    unit = getEnergyHour /(getHourOutput+getDayBadNum);
                }
                unit = Double.parseDouble(dfs.format(unit));
                unitEnergy.put("util" , unit);
                energyUnitList.add(unitEnergy);
            }
        }else if (dimensionality.equals("month")){//月度日级
            List<String> list = DateUtil.getAllTheDateOftheMonth(new Date());
            for(String date: list) {
                Map<String , Object> energyStat = new HashMap<>();
                Map<String , Object> unitEnergy = new HashMap<>();
                getEnergyHour = energyService.getEnergyMonth(deviceId, materialCode, deviceIds, materialCodes ,date);
                getHourOutput = planService.getMonthOutput(deviceId,materialCode ,deviceIds , materialCodes ,date);
                getDayBadNum = qualityService.getMonthBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes , date);
                energyStat.put("date" , date);
                energyStat.put("energy" , getEnergyHour); //月度日级设备能耗统计
                energyStat.put("standard" , standard * 24);//标准能耗
                energyDeviceList.add(energyStat);
                unitEnergy.put("date" , date);
                unitEnergy.put("output" , getHourOutput);//月度日级产量
                unitEnergy.put("bad" , getDayBadNum);//月度日级不良统计
                double unit = 0.00000;//获取月度日级单位能耗统计
                if (getHourOutput+getDayBadNum !=0){
                    unit = getEnergyHour /(getHourOutput+getDayBadNum);
                }
                unit = Double.parseDouble(dfs.format(unit));
                unitEnergy.put("util" , unit);
                energyUnitList.add(unitEnergy);
            }
        }else if (dimensionality.equals("year")){ //年度月级
            List<String> list = DateUtil.getAllTheDateOftheYear(new Date());
            for(String date: list) {
                Map<String , Object> energyStat = new HashMap<>();
                Map<String , Object> unitEnergy = new HashMap<>();
                getEnergyHour = energyService.getEnergyYear(deviceId, materialCode, deviceIds, materialCodes ,date);
                getHourOutput = planService.getYearOutput(deviceId,materialCode,deviceIds,materialCodes ,date);
                getDayBadNum = qualityService.getYearBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes,date);
                energyStat.put("date" , date);
                energyStat.put("energy" , getEnergyHour);//年度月级设备能耗统计
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
                int day = getDaysOfMonth(df.parse(date));
                energyStat.put("standard" , standard * day * 24);//标准能耗
                energyDeviceList.add(energyStat);

                unitEnergy.put("date" , date);
                unitEnergy.put("output" , getHourOutput);//年度月级产量
                unitEnergy.put("bad" , getDayBadNum);//年度月级不良

                double unit = 0.00000; //获取年度月级单位能耗统计
                if (getHourOutput+getDayBadNum !=0){
                    unit = getEnergyHour /(getHourOutput+getDayBadNum);
                }
                unit = Double.parseDouble(dfs.format(unit));
                unitEnergy.put("util" , unit);
                energyUnitList.add(unitEnergy);
            }
        }
        map.put("energyUnitList" , energyUnitList);
        map.put("energyDeviceList" ,energyDeviceList);
        /**********趋势图***********/


        /************获取实时电流***********/
        List<Map<String ,Object>> avgI = new ArrayList<>();
        Map<String ,Object> peakI = new HashMap<>();
        for (int i=0 ; i <=23 ; i++){

            Map<String ,Object> averageI = new HashMap<>();
            String hour = i+"";
            getHourOutput = planService.getHourOutput(deviceId,materialCode ,deviceIds , materialCodes , i);
            getDayBadNum = qualityService.getDayBadNum(deviceId,materialCode,defectiveType,deviceIds,materialCodes,defectiveTypes ,i);
            peakI.put(hour , energyService.getPeakI(deviceId,deviceIds,i));//实时电流曲线
            averageI.put("date" , hour);
            averageI.put("output" ,getHourOutput);//实时电流均值
            averageI.put("bad" , getDayBadNum);
            averageI.put("I" , energyService.getAverageI(deviceId,deviceIds,i));
            avgI.add(averageI);
        }
        map.put("RealI" , peakI);
        map.put("avgI" , avgI);
        /************获取实时电流***********/

        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull, SerializerFeature.DisableCircularReferenceDetect);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getDimensionality", produces = "application/json;charset=UTF-8")
    public String getDimensionality(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        String [] materialCodes = new String[0];
        String materialCode = post.get("materialCode").toString();
        if (!materialCode.equals("all")){
            materialCodes = materialCode.split(",");
        }
        List<Map<String , Object>> deviceList = energyService.getDevice(materialCode,materialCodes);
        List<Map<String , Object>> materialList = energyService.getMaterial();
        map.put("deviceList" ,deviceList);
        map.put("materialList" ,materialList);
        code = 200;
        msg = "获取成功";
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

}
