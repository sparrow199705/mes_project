package com.drs.mes.mapper.mesBase;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlanMapper {

    //设备名称
    List<Map<String , Object >> getDevice();
    List<Map<String , Object >> getDeviceByMaterial(String[] materialCodes);
    //物料名称
    List<Map<String , Object >> getMaterial();
    //总日产量
    int getAllDayOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes);
    //平均小时产量
    double getAVGOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes);
    //日小时级产量
    int getHourOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes , int hour);
    //月度日级产量
    int getMonthOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes ,String day);
    //年度月级产量
    int getYearOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes , String date);
    //低设备OEE TOP10
    List<Map<String , Object >> getLowOEE();
    //标准小时产能
    List<Map<String , Object>> getCapacity(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes);
    //计划小时产能
    List<Map<String , Object>> getPlanCapacity(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes);
    //控制器焊点电流
    List<Map<String , Object>> getControllerI (String controllerId);
    //获取设备id
    List<String> getDeviceId();

}
