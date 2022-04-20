package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportMapper {

    //获取生产产量
    List<StatisticalProductionList> getProductionList(String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime ,int page);

    //获取生产产量数量
    int getProductionTotal(String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime);

    //获取生产产能
    List<StatisticalCapacity> getCapacityList(String deviceId , String deviceName , String materialCode , String materialName , int page);
    int getCapacityTotal(String deviceId , String deviceName , String materialCode , String materialName);

    //获取生产不良
    List<StatisticalBadProduction> getBadProductionList (String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime ,int page);
    int getBadProductionTotal (String deviceId , String deviceName , String materialCode , String materialName , int hour ,String startTime , String endTime );


    //获取设备参数
    List<Map<String , Object>> getParameterList(String deviceId, String deviceName , String startTime , String endTime , int page);
    int getParameterTotal(String deviceId, String deviceName , String startTime , String endTime );

    //获取设备能耗
    List<Map<String , Object>> getEnergyList(String deviceId , String deviceName , int hour , String startTime ,  String endTime , int page);
    int getEnergyTotal(String deviceId , String deviceName , int hour , String startTime ,  String endTime);
    //设备OEE
    List<Map<String , Object>> getOEEList(String deviceId , String deviceName,String startTime ,  String endTime , int page);
    int getOEEListTotal (String deviceId , String deviceName,String startTime ,  String endTime);
}
