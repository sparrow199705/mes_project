package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.*;
import com.drs.mes.service.*;
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
@RequestMapping("/admin/craft")
public class CraftController extends  BaseController{
    private static Logger logger = LoggerFactory.getLogger(AlarmController.class);

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    @Autowired
    private CraftService craftService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ProductionService productionService;

    //添加工艺路线
    @PostMapping(value = "/addCraft", produces = "application/json;charset=UTF-8")
    public String addCraft(@RequestBody List<BasicCraft> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int insetPro = 0;
        int error = 0;
        String errMsg = "";
        for (BasicCraft basicCraft : list) {
            int isHave = craftService.isHave(basicCraft.getCraftCode());
            if (isHave == 0){
                String materialName = productionService.getMaterialName(basicCraft.getMaterialCode());
                basicCraft.setMaterialName(materialName);
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(userId);
                basicCraft.setCraftId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
                basicCraft.setCreateUser(user.getNickname());
                basicCraft.setCreateTime(df.format(new Date()));
                basicCraft.setUpdateUser(user.getNickname());
                basicCraft.setUpdateTime(df.format(new Date()));
                int insert = craftService.addCraft(basicCraft);
                if (insert > 0)
                    insetPro++;
            }else {
                error++;
                errMsg= errMsg+","+basicCraft.getCraftCode();
            }
        }
        if (error == 0){
            code = 200;
            msg = "成功添加:" + insetPro + "条!";
        }else {
            code = 200;
            msg = "成功添加:" + insetPro + "条! 添加失败:" + error +"条!一下编码重复" + errMsg;
        }
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //开关
    @PostMapping(value = "/switchCraft", produces = "application/json;charset=UTF-8")
    public String switchCraft(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int enable = -99;
        int isDeleted = -99;
        if (post.containsKey("enable")){//物料开关
            enable =(int) post.get("enable");
        }
        if (post.containsKey("isDeleted")){//物料删除
            isDeleted = (int)post.get("isDeleted");
        }
        String craftId=post.get("craftId").toString();
        String [] craftIds = craftId.split(",");
        int update = 0;
        for(int a = 0;a<craftIds.length;a++){
            craftService.switchCraft(craftIds[a],enable , isDeleted );
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

    //更新设备
    @PostMapping(value = "/updateCraft", produces = "application/json;charset=UTF-8")
    public String updateCraft(@RequestBody BasicCraft basicCraft, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if (basicCraft.getCraftId() != null) {
            int isHave = craftService.findUpdate(basicCraft.getCraftId() , basicCraft.getCraftCode());
            if (isHave == 0) {
                BasicCraft oldCraft = craftService.getCraftById(basicCraft.getCraftId());
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(userId);
                String materialName = productionService.getMaterialName(basicCraft.getMaterialCode());
                basicCraft.setMaterialName(materialName);
                basicCraft.setCreateTime(oldCraft.getCreateTime());
                basicCraft.setCreateUser(oldCraft.getCreateUser());
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                basicCraft.setUpdateTime(df.format(new Date()));
                basicCraft.setUpdateUser(user.getNickname());
                craftService.switchCraft(basicCraft.getCraftId(),-99, 1);
                int update = craftService.addCraft(basicCraft);
                craftService.updateProcess(basicCraft.getCraftCode() , oldCraft.getCraftCode());
                if (update > 0) {
                    code = 200;
                    msg = "修改成功!";
                    flag = true;
                } else {
                    msg = "修改失败!";
                    flag = false;
                }
            } else {
                msg = "修改失败,工艺编号已存在!";
                flag = false;
            }
        }else {
            msg = "修改失败,缺少工艺ID!";
            flag = false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //工序数据
    @PostMapping(value = "/getProcessList", produces = "application/json;charset=UTF-8")
    public String getProcessList(@RequestBody Map<String, Object> post) {
        Map<String,Object> map = new HashMap<>();
        List<Map<String , Object>> materialsList = processService.getProcessByCraft(post.get("craftCode").toString());
        map.put("data" , materialsList);
        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //工艺数据
    @PostMapping(value = "/getCraftList", produces = "application/json;charset=UTF-8")
    public String getCraftList(@RequestBody CraftFind craftFind) {
        Map<String,Object> map = new HashMap<>();
        craftFind.setPage((craftFind.getPage()-1)*10);
        List<BasicCraft> basicCraftList = craftService.getCraftList(craftFind);
        map.put("data" , basicCraftList);
        map.put("total" , craftService.getCraftTotal(craftFind));
        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //查询框模糊查询
    @PostMapping(value = "/SearchCraft", produces = "application/json;charset=UTF-8")
    public String fuzzySearch(@RequestBody FuzzySearch fuzzySearch) {
        Map<String,Object> map = new HashMap<>();
        List<String> data = craftService.fuzzySearch(fuzzySearch.getSearchKey() , fuzzySearch.getSearch());
        map.put("data" , data);
        code = 200;
        msg="获取成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //关联工序数据
    @PostMapping(value = "/addProcess", produces = "application/json;charset=UTF-8")
    public String addProcess(@RequestBody Map<String, Object> post) {
        Map<String,Object> map = new HashMap<>();
        int isHave = craftService.findPro(post.get("craftCode").toString(),post.get("processCode").toString());
        if (isHave == 0){
            Map<String , Object> getOrderMap = craftService.getProOrder(post.get("craftCode").toString());
            int order = 1;
            if (getOrderMap != null){
                order = Integer.parseInt(getOrderMap.get("orderNum").toString()) +1;
            }
            craftService.addProcess(post.get("craftCode").toString(),post.get("processCode").toString(),order);
            msg="增加成功!";
            flag = true;
        }else {
            msg="工序重复!";
            flag = false;
        }
        code = 200;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //删除工序数据
    @PostMapping(value = "/deleteProcess", produces = "application/json;charset=UTF-8")
    public String deleteProcess(@RequestBody Map<String, Object> post) {
        Map<String,Object> map = new HashMap<>();
        craftService.deletePro(post.get("craftCode").toString(),post.get("processCode").toString());
        msg="删除成功!";
        flag = true;
        code = 200;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //修改工序数据
    @PostMapping(value = "/updateProcess", produces = "application/json;charset=UTF-8")
    public String updateProcess(@RequestBody Map<String, Object> post) {
        Map<String,Object> map = new HashMap<>();
        craftService.deletePro(post.get("craftCode").toString(),null);
        List<Map<String , Object>> list = (List<Map<String, Object>>) post.get("list");
        int order = 0;
        for (Map<String , Object> craftMap : list){
            order ++;
            craftService.addProcess(post.get("craftCode").toString(),craftMap.get("processCode").toString(),order);
        }
        msg="修改成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

}
