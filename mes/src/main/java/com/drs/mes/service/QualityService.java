package com.drs.mes.service;

import com.drs.mes.mapper.mesBase.QualityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QualityService {
    @Autowired
    QualityMapper qualityMapper;

    //不良类型
    public List<Map<String , Object>> badType(){
        return qualityMapper.badType();
    }
    //良品数
    public Map<String , Object> getQualifiedNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes){
        return qualityMapper.getQualifiedNum(deviceId, materialCode, defectiveType, deviceIds, materialCodes, defectiveTypes);
    }
    //获取日不良统计
    public int getDayBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , int hour){
        return qualityMapper.getDayBadNum(deviceId, materialCode, defectiveType, deviceIds, materialCodes, defectiveTypes , hour);
    }
    //月度日级不良统计
    public int getMonthBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , String day){
        return qualityMapper.getMonthBadNum(deviceId, materialCode, defectiveType, deviceIds, materialCodes, defectiveTypes ,day);
    }
    //年度月级不良
    public int getYearBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , String date){
        return  qualityMapper.getYearBadNum(deviceId, materialCode, defectiveType, deviceIds, materialCodes, defectiveTypes , date);
    }

    //产品不良分类
    public List<Map<String, Object>> getBadTypeNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes, String dimensionality){
        return qualityMapper.getBadTypeNum(deviceId, materialCode, defectiveType, deviceIds, materialCodes, defectiveTypes,dimensionality);
    }

    //电流均值分布图
    public List<Map<String , Object>> getElectricity(String deviceId , String[] deviceIds){
        return qualityMapper.getElectricity(deviceId, deviceIds);
    }

    //高不良率TOP10
    public List<Map<String , Object>> getBadTop10(){
        return qualityMapper.getBadTop10();
    }
    //质量预警
    public List<Map<String , Object>> getWarning(){
        return qualityMapper.getWarning();
    }
}
