package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.StatisticalDeviceAlarm;
import com.drs.mes.Pojo.StatisticalProductionEarlyWarning;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AlarmMapper {

    //获取设备告警统计列表
    List<StatisticalDeviceAlarm> getAlarmList(String deviceId , String deviceName , String alarmType , int hour , String startTime , String endTime , int page);
    int getAlarmTotal(String deviceId , String deviceName , String alarmType , int hour , String startTime , String endTime);
    //获取生产预警列表
    List<StatisticalProductionEarlyWarning>getWarningList(String deviceId , String deviceName ,  String warningType , String warningInfo ,String startTime , String endTime , int page);
    int getWarningTotal(String deviceId , String deviceName ,  String warningType , String warningInfo ,String startTime , String endTime);
    //报警明细列表
    List<Map<String , Object>> getDetailList(String deviceId , String deviceName , String alarmDescription ,String alarmType ,String startTime , String endTime , int page) ;
    int getDetailTotal (String deviceId , String deviceName , String alarmDescription ,String alarmType ,String startTime , String endTime ) ;
    //报警明细查询框
    List<String> SearchDetail(@Param("searchKey") String searchKey , @Param("search") String search);

}
