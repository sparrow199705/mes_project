package com.drs.mes.service;

import com.drs.mes.Pojo.BasicProcess;
import com.drs.mes.Pojo.productionProgramme;
import com.drs.mes.mapper.mesBase.ProcessMapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CosNaming.IstringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProcessService {
    @Autowired
    ProcessMapper processMapper;

    //获取工艺列表
    public List<BasicProcess> getProcessList(String processCode , String processName ,String updateUser ,  int enable , String startTime , String endTime , int page){
        return processMapper.getProcessList(processCode, processName,updateUser, enable, startTime, endTime, page);
    }
    public int getProcessListTotal(String processCode , String processName,String updateUser ,int enable , String startTime , String endTime){
        return processMapper.getProcessListTotal(processCode, processName,updateUser, enable, startTime, endTime);
    }

    public int addProcess(BasicProcess basicProcess){
        return processMapper.addProcess(basicProcess);
    }

    public int switchProcess(int enable , int isDeleted , String processId){
        return processMapper.switchProcess(enable, isDeleted, processId);
    }
    public int findUpdate(String processId, String processCode){
        return processMapper.findUpdate(processId, processCode);
    }
    public BasicProcess getProcess(String processIs){
        return processMapper.getProcess(processIs);
    }

    public List<Map<String , Object>>getProcessByCraft(String craftCode){
        return processMapper.getProcessByCraft(craftCode);
    }

    public void updateCraft(String processCode , String oldProcessCode){
        processMapper.updateCraft(processCode,oldProcessCode);
    }
}
