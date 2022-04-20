package com.drs.mes.service;

import com.drs.mes.Pojo.BasicDevice;
import com.drs.mes.mapper.mesBase.DeviceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    //添加设备
    public int addDevice(BasicDevice basicDevice){
        return deviceMapper.addDevice(basicDevice);
    }

    //设备id是否重复
    public int findDeviceById(String deviceId){
        return deviceMapper.findDeviceById(deviceId);
    }

    //设备开关与删除
    public int switchDevice(int enable , int isDeleted , String UUID){
        return deviceMapper.switchDevice(enable , isDeleted , UUID);
    }

    //更新设备
//    public int updateDevice(BasicDevice basicDevice){
//        return deviceMapper.updateDevice(basicDevice);
//    }
    //是否重复
    public int findUpdate(String deviceId , String UUID){
        return deviceMapper.findUpdate(deviceId , UUID);
    }

    //查询框
    public List<String> fuzzySearch(@Param("searchKey") String searchKey , @Param("search") String search){
        return deviceMapper.fuzzySearch(searchKey , search);
    }

    //获取设备列表
    public List<BasicDevice> getDeviceList(int enable  , String deviceId , String deviceName, String deviceType, String deviceCategory,
                                    String updateUser,String startTime , String endTime, int page){
        return deviceMapper.getDeviceList(enable,deviceId,deviceName,deviceType,deviceCategory,updateUser,startTime,endTime,page);
    }

    //获取设备列表Total
    public int getDeviceListTotal(int enable  , String deviceId , String deviceName, String deviceType, String deviceCategory,
                           String updateUser,String startTime , String endTime){
        return deviceMapper.getDeviceListTotal(enable,deviceId,deviceName,deviceType,deviceCategory,updateUser,startTime,endTime);
    }

    //通过设备id获取设备
    public BasicDevice getDevice(String UUID){
        return deviceMapper.getDevice(UUID);
    }

    //通过设备Id获取设备生产信息
    public Map<String , Object> getDeviceByDeviceId(String deviceId){
        return deviceMapper.getDeviceByDeviceId(deviceId);
    }

    //获取当日设备产量
    public int getDeviceOutput(String deviceId){
        return deviceMapper.getDeviceOutput(deviceId);
    }
    //获取运行状态
    public String getDeviceState(String deviceId){
        return deviceMapper.getDeviceState(deviceId);
    }
    //设备当日不良产量
    public int getDeviceDayBad(String deviceId){
        return deviceMapper.getDeviceDayBad(deviceId);
    }
    //获取设备当日能耗
    public double getDeviceEP(String deviceId){
        return deviceMapper.getDeviceEP(deviceId);
    }
    //获取设备关键参数
    public List<Map<String, Object>> getDeviceParameter(String deviceId){
        return deviceMapper.getDeviceParameter(deviceId);
    }
    //设备OEE平均值
    public double getOEEHour(int hour , String deviceId){
        return deviceMapper.getOEEHour(hour , deviceId);
    }
    //获取全部设备
    public List<Map<String, Object>> getAllDevice(){
        return deviceMapper.getAllDevice();
    }
    //实时电流
    public double getCurrent(int hour , int minute , String deviceId){
        return deviceMapper.getCurrent(hour, minute ,deviceId);
    }
    //报警次数统计
    public List<Map<String , Object>> getAlarmType(String deviceId){
        return deviceMapper.getAlarmType(deviceId);
    }
    //设备报警明细数据
    public List<Map<String , Object>> getAlarm(String deviceId){
        return deviceMapper.getAlarm(deviceId);
    }
    //获取设备Id
    public String getDeviceId(){
        return deviceMapper.getDeviceId();
    }
    //获取设备名
    public String getDeviceName(String deviceId){
        return deviceMapper.getDeviceName(deviceId);
    }

    public void updatePro(String deviceId , String deviceName , String oldDeviceId){
        deviceMapper.updatePro(deviceId, deviceName, oldDeviceId);
    }

}
