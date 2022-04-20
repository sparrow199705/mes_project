package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.BasicDevice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface DeviceMapper {

    //添加设备
    int addDevice(BasicDevice basicDevice);

    //设备id是否重复
    int findDeviceById(String deviceId);

    //设备开关与删除
    int switchDevice(int enable , int isDeleted , String UUID);

    //更新设备
//    int updateDevice(BasicDevice basicDevice);
    //是否重复
    int findUpdate(String deviceId , String UUID);


    //查询框
    List<String> fuzzySearch(@Param("searchKey") String searchKey , @Param("search") String search);

    //获取设备列表
    List<BasicDevice> getDeviceList(int enable  , String deviceId , String deviceName, String deviceType, String deviceCategory,
                                    String updateUser,String startTime , String endTime, int page);
    //获取设备列表Total
    int getDeviceListTotal(int enable  , String deviceId , String deviceName, String deviceType, String deviceCategory,
                                    String updateUser,String startTime , String endTime);

    //通过设备id获取设备
    BasicDevice getDevice(String UUID);
    //通过设备Id获取设备生产信息
    Map<String , Object>getDeviceByDeviceId(String deviceId);
    //获取当日设备产量
    int getDeviceOutput(String deviceId);
    //设备当日不良产量
    int getDeviceDayBad(String deviceId);
    //获取运行状态
    String getDeviceState(String deviceId);
    //获取设备当日能耗
    double getDeviceEP(String deviceId);
    //获取设备关键参数
    List<Map<String, Object>> getDeviceParameter(String deviceId);
    //设备OEE平均值
    double getOEEHour(int hour , String deviceId);
    //获取全部设备
    List<Map<String, Object>> getAllDevice();
    //实时电流
    double getCurrent(int hour , int minute , String deviceId);
    //报警次数统计
    List<Map<String , Object>> getAlarmType(String deviceId);
    //设备报警明细数据
    List<Map<String , Object>> getAlarm(String deviceId);
    //获取设备Id
    String getDeviceId();
    //获取设备名
    String getDeviceName(String deviceId);

    void updatePro(String deviceId , String deviceName , String oldDeviceId);
}
