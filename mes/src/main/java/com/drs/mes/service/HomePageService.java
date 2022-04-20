package com.drs.mes.service;

import com.drs.mes.mapper.mesBase.HomePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomePageService {
    @Autowired
    HomePageMapper homePageMapper;

    //日产量
    public List<Map<String , Object>>getDayOutput(){
        return homePageMapper.getDayOutput();
    }
    public int getDayOutputByM(String materialName){
        return  homePageMapper.getDayOutputByM(materialName);
    }

    //月产量
    public List<Map<String , Object>>getMothOutput(){
        return homePageMapper.getMothOutput();
    }

    //日产品不良数
    public List<Map<String , Object>> getBadOutput(){
        return homePageMapper.getBadOutput();
    }
    //日产量总数
    public int getAllDayOutput(){
        return homePageMapper.getAllDayOutput();
    }
    public int getOutputByD(String deviceId){
        return homePageMapper.getOutputByD(deviceId);
    }

    //设备OEE平均值
    public double getOEE(){
        return homePageMapper.getOEE();
    }
    public double getOEEByD(String deviceId){
        return homePageMapper.getOEEByD(deviceId);
    }
    //获取当日不良总数
    public int getAllBadOutput(){
        return homePageMapper.getAllBadOutput();
    }
    public int getBadByD(String deviceId){
        return homePageMapper.getBadByD(deviceId);
    }

    //实时能耗
    public List<Map<String , Object>> getTimeEP(){
        return  homePageMapper.getTimeEP();
    }
    //当日能耗总和
    public int getAllEP(){
        return homePageMapper.getAllEP();
    }

    //总设备数
    public int getDeviceNum(){
        return  homePageMapper.getDeviceNum();
    }

    //获取设备状态
    public String getDeviceState(String deviceId){
        return homePageMapper.getDeviceState(deviceId);
    }

    //获取状态数量
    public List<Map<String , Object>> getOnlineDevice(){
        return homePageMapper.getOnlineDevice();
    }

    //报警分类统计
    public List<Map<String , Object>> getAlarmType(){
        return homePageMapper.getAlarmType();
    }
    //获取所有设备
    public List<Map<String ,Object>>getAllDevice(){
        return homePageMapper.getAllDevice();
    }
    //生产预警分类统计
    public List<Map<String , Object>> getWarningType(){
        return homePageMapper.getWarningType();
    }
}
