package com.drs.mes.mapper.mesBase;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HomePageMapper {


    //日产量
    List<Map<String , Object>>getDayOutput();

    //月产量
    List<Map<String , Object>>getMothOutput();
    int getDayOutputByM(String materialName);

    //日产品不良数
    List<Map<String , Object>> getBadOutput();
    int getBadByD(String deviceId);
    //日产量总数
    int getAllDayOutput();
    int getOutputByD(String deviceId);
    //设备OEE平均值
    double getOEE();
    double getOEEByD(String deviceId);
    //获取当日不良总数
    int getAllBadOutput();

    //实时能耗
    List<Map<String , Object>>getTimeEP();
    //当日能耗总和
    int getAllEP();


    //总设备数
    int getDeviceNum();
    //获取所有设备
    List<Map<String ,Object>>getAllDevice();

    //获取设备状态
    String getDeviceState(String deviceId);

    //获取状态数量
    List<Map<String , Object>> getOnlineDevice();
    //报警分类统计
    List<Map<String , Object>> getAlarmType();
    //生产预警分类统计
    List<Map<String , Object>> getWarningType();

}
