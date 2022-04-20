package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.*;
import com.drs.mes.service.ProcessService;
import com.drs.mes.service.UserService;
import com.drs.mes.util.TokenUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin/process")
public class ProcessController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private ProcessService processService;
    @Autowired
    private UserService userService;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


    /***************************************************工序数据********************************************/
    //工艺数据
    @PostMapping(value = "/getProcessList", produces = "application/json;charset=UTF-8")
    public String getProcessList(@RequestBody SearchProcess searchProcess) {
        Map<String,Object> map = new HashMap<>();
        List<BasicProcess> materialsList = processService.getProcessList(searchProcess.getProcessCode(),searchProcess.getProcessName(),searchProcess.getUpdateUser(),searchProcess.getEnable(),
                searchProcess.getStartTime(),searchProcess.getEndTime(),(searchProcess.getPage()-1)*10);//物料list
        map.put("data" , materialsList);
        map.put("total" , processService.getProcessListTotal(searchProcess.getProcessCode(),searchProcess.getProcessName(),searchProcess.getUpdateUser(),searchProcess.getEnable(),
                searchProcess.getStartTime(),searchProcess.getEndTime()));//物料total
        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //添加生产规划
    @PostMapping(value = "/addProcess", produces = "application/json;charset=UTF-8")
    public String addProcess(@RequestBody List<BasicProcess> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int insetPro = 0;
        int error = 0;
        for (BasicProcess basicProcess : list) {
            int isHave = processService.findUpdate(null, basicProcess.getProcessCode());
            if (isHave == 0){
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(userId);
                basicProcess.setProcessId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
                basicProcess.setCreateTime(df.format(new Date()));
                basicProcess.setCreateUser(user.getNickname());
                basicProcess.setUpdateTime(df.format(new Date()));
                basicProcess.setUpdateUser(user.getNickname());
                processService.addProcess(basicProcess);
                insetPro ++;
            }else {
                error++;
            }
        }
        code = 200;
        msg="成功添加:"+insetPro+"条!";
        if (error>0)
            msg="成功添加:"+insetPro+"条,生产规划重复:"+error+"条!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //修改生产规划
    @PostMapping(value = "/updateProcess", produces = "application/json;charset=UTF-8")
    public String updateProcess(@RequestBody BasicProcess basicProcess, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int isHave = processService.findUpdate(basicProcess.getProcessId(), basicProcess.getProcessCode());
        if (isHave == 0) {
            int id = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
            User user = userService.getUserById(id);
            BasicProcess oldProcess = processService.getProcess(basicProcess.getProcessId());
            basicProcess.setCreateUser(oldProcess.getCreateUser());
            basicProcess.setCreateTime(oldProcess.getCreateTime());
            basicProcess.setUpdateTime(df.format(new Date()));
            basicProcess.setUpdateUser(user.getNickname());
            processService.switchProcess(-99 , 1 , basicProcess.getProcessId());
            processService.updateCraft(basicProcess.getProcessCode() , oldProcess.getProcessCode());
            processService.addProcess(basicProcess);
        }
        code = 200;
        msg="修改成功";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //生产规划开关
    @PostMapping(value = "/switchProcess", produces = "application/json;charset=UTF-8")
    public String switchProduction(@RequestBody Map<String , Object> post, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int enable = -99;
        int isDeleted = -99;
        if (post.containsKey("enable")){//物料开关
            enable =(int) post.get("enable");
        }
        if (post.containsKey("isDeleted")){//物料删除
            isDeleted = (int)post.get("isDeleted");
        }
        String processCode=post.get("processId").toString();
        String [] processCodes = processCode.split(",");
        int update = 0;
        for(int a = 0;a<processCodes.length;a++){
            processService.switchProcess(enable , isDeleted , processCodes[a]);
            update++;
        }
        if (update >0){
            code = 200;
            msg = "成功修改:"+update+"条!";
            flag = true;
        }else {
            msg = "修改失败!";
            flag = false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }
}
