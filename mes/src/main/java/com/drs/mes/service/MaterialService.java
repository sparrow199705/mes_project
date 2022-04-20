package com.drs.mes.service;

import com.drs.mes.Pojo.BasicMaterials;
import com.drs.mes.Pojo.SearchMaterial;
import com.drs.mes.mapper.mesBase.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    //获取物料列表
    public List<BasicMaterials> getMaterialList(int enable , int isDeleted , String materialCode , String materialName,
                                                String materialType, String materialSeries,String updateUser, String startTime , String endTime ,int page){
        return materialMapper.getMaterialList(enable,isDeleted,materialCode,materialName,materialType,materialSeries,updateUser,startTime,endTime,page);
    }
    public int getMaterialListTotal(int enable , int isDeleted , String materialCode , String materialName,
                                    String materialType, String materialSeries ,String updateUser,String startTime , String endTime){
        return materialMapper.getMaterialListTotal(enable,isDeleted,materialCode,materialName,materialType,materialSeries,updateUser,startTime,endTime);
    }

    //新建物料
    public int addMaterial(BasicMaterials basicMaterials){
        return materialMapper.addMaterial(basicMaterials);
    }
    public int findMaterialByCode(String materialCode){
        return materialMapper.findMaterialByCode(materialCode);
    }

    //物料开关
    public int switchMaterial(long enable , long isDeleted , String materialId){
        return materialMapper.switchMaterial(enable , isDeleted , materialId);
    }

    //更新物料
    public int updateMaterial (BasicMaterials basicMaterials){
        return materialMapper.updateMaterial(basicMaterials);
    }
    public int findUpdate(String materialCode , String materialId){
        return materialMapper.findUpdate(materialCode , materialId);
    }


    //查询框模糊查询
    public  List<String> fuzzySearch(String searchKey , String search){
        return materialMapper.fuzzySearch(searchKey,search);
    }
    //通过物料ID获取物料
    public BasicMaterials getMaterial(String materialId){
        return materialMapper.getMaterial(materialId);
    }

    //物料更新后同步计划
    public void updatePro(String materialCode , String materialName , String oldMaterialCode){
        materialMapper.updatePro(materialCode, materialName, oldMaterialCode);
    }
    public void updateCraft(String materialCode , String materialName , String oldMaterialCode){
        materialMapper.updateCraft(materialCode, materialName, oldMaterialCode);
    }
}
