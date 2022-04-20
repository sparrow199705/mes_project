package com.drs.mes.mapper.mesBase;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QualityMapper {
    //不良类型
    List<Map<String , Object>> badType();
    //良品数与不良数
    Map<String , Object> getQualifiedNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes);
    //获取日不良统计
    int getDayBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , int hour);
    //月度日级不良统计
    int getMonthBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes ,String day);
    //年度月级不良
    int getYearBadNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , String date);
    //产品不良分类
    List<Map<String, Object>> getBadTypeNum(String deviceId , String materialCode , String defectiveType , String[] deviceIds , String[] materialCodes , String[] defectiveTypes , String dimensionality);
    //电流均值分布图
    List<Map<String , Object>> getElectricity(String deviceId , String[] deviceIds);
    //高不良率TOP10
    List<Map<String , Object>> getBadTop10();
    //质量预警
    List<Map<String , Object>> getWarning();

}
