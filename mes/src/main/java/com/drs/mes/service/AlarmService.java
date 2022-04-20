package com.drs.mes.service;

import com.drs.mes.Pojo.StatisticalDeviceAlarm;
import com.drs.mes.Pojo.StatisticalProductionEarlyWarning;
import com.drs.mes.mapper.mesBase.AlarmMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlarmService {
    @Autowired
    AlarmMapper alarmMapper;

    //获取设备告警统计列表
    public List<StatisticalDeviceAlarm> getAlarmList(String deviceId , String deviceName , String alarmType , int hour , String startTime , String endTime , int page){
        return alarmMapper.getAlarmList(deviceId,deviceName,alarmType,hour,startTime,endTime,page);
    }
    public int getAlarmTotal(String deviceId , String deviceName , String alarmType , int hour , String startTime , String endTime){
        return alarmMapper.getAlarmTotal(deviceId,deviceName,alarmType,hour,startTime,endTime);
    }
    //生产预警列表
    public List<StatisticalProductionEarlyWarning>getWarningList(String deviceId , String deviceName , String warningType , String warningInfo , String startTime , String endTime , int page){
        return alarmMapper.getWarningList(deviceId, deviceName, warningType, warningInfo, startTime, endTime, page);
    }
    public int getWarningTotal(String deviceId , String deviceName ,  String warningType , String warningInfo ,String startTime , String endTime){
        return alarmMapper.getWarningTotal(deviceId, deviceName, warningType, warningInfo, startTime, endTime);
    }

    //报警明细查询框
    public List<String> SearchDetail(@Param("searchKey") String searchKey , @Param("search") String search){
        return alarmMapper.SearchDetail(searchKey, search);
    }
    //报警明细列表
    public List<Map<String , Object>> getDetailList(String deviceId , String deviceName , String alarmDescription , String alarmType , String startTime , String endTime , int page) {
        return alarmMapper.getDetailList(deviceId,deviceName,alarmDescription,alarmType,startTime,endTime,page);
    }
    public int getDetailTotal (String deviceId , String deviceName , String alarmDescription ,String alarmType ,String startTime , String endTime ) {
        return alarmMapper.getDetailTotal(deviceId, deviceName, alarmDescription, alarmType, startTime, endTime);
    }

}
