package com.drs.mes.service;

import com.drs.mes.Pojo.*;
import com.drs.mes.mapper.mesBase.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    //获取生产产量
    public List<StatisticalProductionList> getProductionList(String deviceId , String deviceName , String materialCode , String materialName ,
                                                         int hour ,String startTime , String endTime ,int page){
        return reportMapper.getProductionList(deviceId,deviceName,materialCode,materialName,hour,startTime,endTime,page);
    }

    //获取生产产量数量
    public int getProductionTotal(String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime){
        return reportMapper.getProductionTotal(deviceId,deviceName,materialCode,materialName,hour,startTime,endTime);
    }

    //获取生产产能
    public List<StatisticalCapacity> getCapacityList(String deviceId , String deviceName , String materialCode , String materialName , int page){
        return reportMapper.getCapacityList(deviceId,deviceName,materialCode,materialName,page);
    }

    public int getCapacityTotal(String deviceId , String deviceName , String materialCode , String materialName){
        return reportMapper.getCapacityTotal(deviceId,deviceName,materialCode,materialName);
    }

    //获取生产不良
    public List<StatisticalBadProduction> getBadProductionList (String deviceId , String deviceName , String materialCode , String materialName , int hour , String startTime , String endTime , int page){
        return reportMapper.getBadProductionList(deviceId,deviceName,materialCode,materialName,hour,startTime,endTime,page);
    }
    public int getBadProductionTotal (String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime ){
        return reportMapper.getBadProductionTotal(deviceId,deviceName,materialCode,materialName,hour,startTime,endTime);
    }

    //获取设备参数
    public List<Map<String , Object>> getParameterList(String deviceId, String deviceName , String startTime , String endTime , int page){
        return reportMapper.getParameterList(deviceId,deviceName,startTime,endTime,page);
    }
    public int getParameterTotal(String deviceId, String deviceName , String startTime , String endTime ){
        return reportMapper.getParameterTotal(deviceId,deviceName,startTime,endTime);
    }

    //获取设备能耗
    public List<Map<String , Object>> getEnergyList(String deviceId , String deviceName , int hour , String startTime , String endTime , int page){
        return reportMapper.getEnergyList(deviceId,deviceName,hour,startTime,endTime,page);
    }
    public int getEnergyTotal(String deviceId , String deviceName , int hour , String startTime ,  String endTime){
        return reportMapper.getEnergyTotal(deviceId,deviceName,hour,startTime,endTime);
    }

    //设备OEE
    public List<Map<String , Object>> getOEEList(String deviceId , String deviceName, String startTime , String endTime , int page){
        return reportMapper.getOEEList(deviceId, deviceName, startTime, endTime, page);
    }
    public int getOEEListTotal (String deviceId , String deviceName,String startTime ,  String endTime){
        return reportMapper.getOEEListTotal(deviceId, deviceName, startTime, endTime);
    }
}
