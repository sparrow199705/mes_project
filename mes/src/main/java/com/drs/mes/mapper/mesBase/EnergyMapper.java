package com.drs.mes.mapper.mesBase;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EnergyMapper {

    //日实施能耗
    double getDayEP(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes);
    //平均小时能耗
    double getAverageEP(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes);
    //标准能耗
    double getCapacity(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes);
    //设备名称
    List<Map<String , Object>>getDevice(String materialCode ,  String[] materialCodes);
    //物料名称
    List<Map<String , Object>>getMaterial();
    //日级小时能耗
    double getEnergyHour(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes , int hour);
    // 月度日级能耗
    double getEnergyMonth(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes,String day);
    //年度月级设备能耗统计
    double getEnergyYear(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes , String date);
    //获取实时电流
    double getPeakI(String deviceId , String[] deviceIds , int hour);
    //实时电流均值统计
    double getAverageI(String deviceId , String[] deviceIds , int hour);
}
