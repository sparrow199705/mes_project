package com.drs.mes.service;

import com.drs.mes.Pojo.BasicCraft;
import com.drs.mes.Pojo.CraftFind;
import com.drs.mes.mapper.mesBase.CraftMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CraftService {
    @Autowired
    CraftMapper craftMapper;

    //添加工艺
    public int addCraft(BasicCraft basicCraft){
        return craftMapper.addCraft(basicCraft);
    }

    //是否重复编码
    public int isHave(String craftCode){
        return craftMapper.isHave(craftCode);
    }

    //开关
    public int switchCraft(String craftId,int enable , int isDeleted){
        return craftMapper.switchCraft(craftId, enable, isDeleted);
    }
    //通过craftId获取basicCraft
    public BasicCraft getCraftById(String craftId){
        return craftMapper.getCraftById(craftId);
    }
    public int findUpdate(String craftId , String craftCode){
        return craftMapper.findUpdate(craftId ,craftCode);
    }
    //更新工序
    public void updateProcess(String craftCode, String oldCraftCode){
        craftMapper.updateProcess(craftCode, oldCraftCode);
    }
    public List<BasicCraft> getCraftList(CraftFind craftFind){
        return craftMapper.getCraftList(craftFind);
    }
    public int getCraftTotal(CraftFind craftFind){
        return craftMapper.getCraftTotal(craftFind);
    }
    public List<String> fuzzySearch(@Param("searchKey") String searchKey , @Param("search") String search){
        return craftMapper.fuzzySearch(searchKey , search);
    }
    public int addProcess(String craftCode , String processCode , int order){
        return craftMapper.addProcess(craftCode, processCode, order);
    }
    public int findPro(String craftCode , String processCode){
        return craftMapper.findPro(craftCode, processCode);
    }

    public void deletePro(String craftCode , String processCode){
        craftMapper.deletePro(craftCode, processCode);
    }

    public Map<String , Object> getProOrder(String craftCode){
        return craftMapper.getProOrder(craftCode);
    }

}
