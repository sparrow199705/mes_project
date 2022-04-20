package com.drs.mes.service;

import com.drs.mes.mapper.mesBase.EnergyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnergyService {
    @Autowired
    EnergyMapper energyMapper;

    //日实施能耗
    public double getDayEP(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes){
        return energyMapper.getDayEP(deviceId, materialCode, deviceIds, materialCodes);
    }
    //平均小时能耗
    public double getAverageEP(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes){
        return energyMapper.getAverageEP(deviceId, materialCode, deviceIds, materialCodes);
    }
    //标准能耗
    public double getCapacity(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes){
        return energyMapper.getCapacity(deviceId, materialCode, deviceIds, materialCodes);
    }
    //设备名称
    public List<Map<String , Object>> getDevice(String materialCode , String[] materialCodes){
        return energyMapper.getDevice(materialCode, materialCodes);
    }
    //物料名称
    public List<Map<String , Object>>getMaterial(){
        return energyMapper.getMaterial();
    }
    //日级小时设备能耗统计
    public double getEnergyHour(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes , int hour){
        return energyMapper.getEnergyHour(deviceId, materialCode, deviceIds, materialCodes , hour);
    }
    // 月度日级设备能耗统计
    public double getEnergyMonth(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes , String day){
        return energyMapper.getEnergyMonth(deviceId, materialCode, deviceIds, materialCodes , day);
    }
    //年度月级设备能耗统计
    public double getEnergyYear(String deviceId , String materialCode , String[] deviceIds , String[] materialCodes ,String date){
        return energyMapper.getEnergyYear(deviceId, materialCode, deviceIds, materialCodes ,date);
    }
    //获取实时电流
    public double getPeakI(String deviceId , String[] deviceIds , int hour){
        return energyMapper.getPeakI(deviceId, deviceIds, hour);
    }
    //实时电流均值统计
    public double getAverageI(String deviceId , String[] deviceIds , int hour){
        return energyMapper.getAverageI(deviceId, deviceIds, hour);
    }
}
