package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.BasicMaterials;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {

    List<BasicMaterials> getMaterialList(int enable , int isDeleted , String materialCode , String materialName,
                                         String materialType, String materialSeries , String updateUser,String startTime , String endTime, int page);
    int getMaterialListTotal(int enable , int isDeleted , String materialCode  ,String materialName,
                             String materialType, String materialSeries ,String updateUser ,String startTime , String endTime);

    //新建物料
    int addMaterial(BasicMaterials basicMaterials);
    int findMaterialByCode(String materialCode);

    //物料开关
    int switchMaterial(long enable , long isDeleted , String materialId);

    //更新物料
    int updateMaterial (BasicMaterials basicMaterials);
    int findUpdate(String materialCode , String materialId);

    //查询框模糊查询
    List<String> fuzzySearch(@Param("searchKey") String searchKey ,@Param("search") String search);

    //通过物料ID获取物料
    BasicMaterials getMaterial(String materialId);

    //物料更新后同步计划
    void updatePro(String materialCode , String materialName , String oldMaterialCode);
    void updateCraft(String materialCode , String materialName , String oldMaterialCode);
}
