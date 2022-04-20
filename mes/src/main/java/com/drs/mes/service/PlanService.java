package com.drs.mes.service;

import com.drs.mes.mapper.mesBase.PlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanService {
    @Autowired
    PlanMapper planMapper;


    //设备名称
    public List<Map<String , Object >> getDevice(){
        return  planMapper.getDevice();
    }
    public List<Map<String , Object >> getDeviceByMaterial(String[] materialCodes){
        return planMapper.getDeviceByMaterial(materialCodes);
    }
    //物料名称
    public List<Map<String , Object >> getMaterial(){
        return planMapper.getMaterial();
    }
    //总日产量
    public int getAllDayOutput(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes){
        return planMapper.getAllDayOutput(deviceId,materialCode,deviceIds , materialCodes);
    }
    //平均小时产量
    public double getAVGOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes){
        return planMapper.getAVGOutput(deviceId,materialCode,deviceIds , materialCodes);
    }
    //日小时级产量
    public int getHourOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes , int hour){
        return planMapper.getHourOutput(deviceId,materialCode,deviceIds , materialCodes , hour);
    }
    //月度日级产量
    public int getMonthOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes , String day){
        return planMapper.getMonthOutput(deviceId,materialCode,deviceIds,materialCodes ,day);
    }
    //年度月级产量
    public int getYearOutput(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes ,String date){
        return planMapper.getYearOutput(deviceId,materialCode,deviceIds,materialCodes ,date);
    }
    //低设备OEE TOP10
    public List<Map<String , Object >> getLowOEE(){
        return planMapper.getLowOEE();
    }

    //标准小时产能
    public List<Map<String , Object>> getCapacity(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes){
        return planMapper.getCapacity(deviceId, materialCode, deviceIds, materialCodes);
    }
    //计划小时产能
    public List<Map<String , Object>> getPlanCapacity(String deviceId , String materialCode ,String[] deviceIds , String[] materialCodes){
        return planMapper.getPlanCapacity(deviceId, materialCode, deviceIds, materialCodes);
    }
    //控制器焊点电流
    public List<Map<String , Object>> getControllerI (String controllerId){
        return planMapper.getControllerI(controllerId);
    }
    //获取设备id
    public List<String> getDeviceId(){
        return planMapper.getDeviceId();
    }
}
