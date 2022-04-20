package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.productionProgramme;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionMapper {
    //新增生产规划
    int addProduction(productionProgramme productionProgramme);
    //是否重复
    int findProductionById(String processCode);

    //生产规划开关与删除
    int switchProduction(int enable , int isDeleted , String productionId );

    //更新生产规划
    int updateProduction(productionProgramme productionProgramme);
    //是否重复
    int findUpdate(String processCode , long id);
    //查询框
    List<String> SearchProduction(@Param("searchKey") String searchKey , @Param("search") String search);
    //获取生产规划列表
    List<productionProgramme> getProductionList(int enable  , String deviceId , String deviceName, String processCode, String processName,
                                             String materialCode , String materialName, String updateUser, String startTime , String endTime,
                                             int page);

    //获取生产规划列表Total
    int getProductionListTotal(int enable  , String deviceId , String deviceName, String processCode, String processName,
                            String materialCode ,String materialName,String updateUser,String startTime , String endTime);

    //获取生产规划
    productionProgramme getProduction (long id);
    //获取设备名称
    String getDeviceName(String deviceId);
    //获取物料名称
    String getMaterialName(String materialCode);
    //获取工艺名称
    String getProcessName(String processCode);
    //是否重复计划
    int isHave(String deviceId , String materialCode , String productionId);
}
