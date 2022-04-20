package com.drs.mes.service;

import com.drs.mes.Pojo.productionProgramme;
import com.drs.mes.mapper.mesBase.ProductionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {
    @Autowired
    ProductionMapper productionMapper;

    //新增生产规划
    public int addProduction(productionProgramme productionProgramme){
        return productionMapper.addProduction(productionProgramme);
    }

    //生产规划开关与删除
    public int switchProduction(int enable , int isDeleted , String productionId ){
        return productionMapper.switchProduction(enable, isDeleted, productionId);
    }

    //更新生产规划
    public int updateProduction(productionProgramme productionProgramme){
        return productionMapper.updateProduction(productionProgramme);
    }
    //查询框
    public List<String> SearchProduction(@Param("searchKey") String searchKey , @Param("search") String search){
        return productionMapper.SearchProduction(searchKey, search);
    }
    //获取生产规划列表
    public List<productionProgramme> getProductionList(int enable  , String deviceId , String deviceName, String processCode, String processName,
                                                String materialCode , String materialName, String updateUser, String startTime , String endTime,
                                                int page){
        return productionMapper.getProductionList(enable, deviceId, deviceName, processCode, processName, materialCode, materialName, updateUser, startTime, endTime, page);
    }

    //获取生产规划列表Total
    public int getProductionListTotal(int enable  , String deviceId , String deviceName, String processCode, String processName,
                               String materialCode ,String materialName,String updateUser,String startTime , String endTime){
        return productionMapper.getProductionListTotal(enable, deviceId, deviceName, processCode, processName, materialCode, materialName, updateUser, startTime, endTime);
    }

    //获取生产规划
    public productionProgramme getProduction (long id){
        return productionMapper.getProduction(id);
    }
    //获取设备名称
    public String getDeviceName(String deviceId){
        return productionMapper.getDeviceName(deviceId);
    }
    //获取物料名称
    public String getMaterialName(String materialCode){
        return productionMapper.getMaterialName(materialCode);
    }

    //获取工艺名称
    public  String getProcessName(String processCode){
        return productionMapper.getProcessName(processCode);
    }

    //是否重复计划
    public int isHave(String deviceId , String materialCode , String productionId){
        return productionMapper.isHave(deviceId, materialCode, productionId);
    }
}
