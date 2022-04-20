package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.BasicCraft;
import com.drs.mes.Pojo.CraftFind;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CraftMapper {
    //添加工艺
    int addCraft(BasicCraft basicCraft);
    //是否重复编码
    int isHave(String craftCode);
    //开关
    int switchCraft(String craftId,int enable , int isDeleted);
    //通过craftId获取basicCraft
    BasicCraft getCraftById(String craftId);
    //
    int findUpdate(String craftId , String craftCode);
    //更新工序
    void updateProcess(String craftCode, String oldCraftCode);

    List<BasicCraft> getCraftList(CraftFind craftFind);
    int getCraftTotal(CraftFind craftFind);
    List<String> fuzzySearch(@Param("searchKey") String searchKey , @Param("search") String search);
    int addProcess(String craftCode , String processCode , int order);
    int findPro(String craftCode , String processCode);
    void deletePro(String craftCode , String processCode);
    Map<String , Object> getProOrder(String craftCode);
}
