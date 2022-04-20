package com.drs.mes.mapper.mesBase;

import com.drs.mes.Pojo.BasicProcess;
import org.apache.poi.examples.xwpf.usermodel.UpdateEmbeddedDoc;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ProcessMapper {
    //获取工艺列表
    List<BasicProcess> getProcessList(String processCode , String processName ,String updateUser,int enable , String startTime , String endTime , int page);
    int getProcessListTotal(String processCode , String processName , String updateUser, int enable , String startTime , String endTime);

    int addProcess(BasicProcess basicProcess);

    int switchProcess(int enable , int isDeleted , String processId);

    int findUpdate(String processId , String processCode);

    BasicProcess getProcess(String processIs);

    List<Map<String , Object>> getProcessByCraft(String craftCode);

    void updateCraft(String processCode , String oldProcessCode);
}
