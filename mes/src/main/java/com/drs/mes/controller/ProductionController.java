package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.FuzzySearch;
import com.drs.mes.Pojo.SearchProcess;
import com.drs.mes.Pojo.User;
import com.drs.mes.Pojo.productionProgramme;
import com.drs.mes.service.ProductionService;
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
@RequestMapping("/admin/production")
public class ProductionController extends BaseController{
    @Autowired
    ProductionService productionService;
    @Autowired
    UserService userService;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    private static Logger logger = LoggerFactory.getLogger(ProcessController.class);

    //添加生产规划
    @PostMapping(value = "/addProduction", produces = "application/json;charset=UTF-8")
    public String addProduction(@RequestBody List<productionProgramme> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int insetPro = 0;
        int errorDevice = 0;
        int errorMa = 0;
        int errorPro = 0;
        int have = 0;
        String notFound = "";
        String notFoundMa = "";
        String notFoundPro = "";
        String haveStr = "";
        for (productionProgramme productionProgramme : list) {
            int isHave = productionService.isHave(productionProgramme.getDeviceId() , productionProgramme.getMaterialCode() , null);
            if (isHave == 0){
                String productionId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                String deviceName = productionService.getDeviceName(productionProgramme.getDeviceId());
                String materialName = productionService.getMaterialName(productionProgramme.getMaterialCode());
                String processName = productionService.getProcessName(productionProgramme.getProcessCode());
                if (deviceName != null && materialName != null  && processName != null){
                    productionProgramme.setDeviceName(deviceName);
                    productionProgramme.setMaterialName(materialName);
                    productionProgramme.setProcessName(processName);
                    productionProgramme.setProductionId(productionId);
                    int id = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                    User user = userService.getUserById(id);
                    productionProgramme.setUpdateTime(df.format(new Date()));
                    productionProgramme.setUpdateUser(user.getNickname());
                    productionService.addProduction(productionProgramme);
                    insetPro ++;
                }else if (deviceName == null){
                    notFound = notFound+","+productionProgramme.getDeviceId();
                    errorDevice++;
                }else if (materialName == null){
                    notFoundMa = notFoundMa + "," + productionProgramme.getMaterialCode();
                    errorMa++;
                }else if (processName == null){
                    notFoundPro =notFoundPro+ ","+ productionProgramme.getProcessCode();
                    errorPro++;
                }
            }else {
                have++;
                haveStr = haveStr +",该设备与物料重复,设备:"+productionProgramme.getDeviceId()+",编码:"+productionProgramme.getMaterialCode();
            }
        }

        if (insetPro == 0){
            msg="添加失败";
            code = 500;
        }else {
            code = 200;
            msg="成功添加:"+insetPro+"条!";
            if (errorDevice>0 || errorMa >0 || errorPro>0)
                msg="成功添加:"+insetPro+"条,以下设备编码不存在"+notFound+"!以下物料编码不存在"+notFoundMa+"!以下工艺编码不存在" + notFoundPro+"!";
            if (have >0)
                msg+= haveStr;
        }
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //生产规划开关
    @PostMapping(value = "/switchProduction", produces = "application/json;charset=UTF-8")
    public String switchProduction(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int enable = -99;
        int isDeleted = -99;
        if (post.containsKey("enable")){//开关
            enable =(int) post.get("enable");
        }
        if (post.containsKey("isDeleted")){//删除
            isDeleted = (int)post.get("isDeleted");
        }
        String processCode=post.get("productionId").toString();
        String [] processCodes = processCode.split(",");
        int update = 0;
        for(int a = 0;a<processCodes.length;a++){
            productionService.switchProduction(enable , isDeleted ,processCodes[a]);
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


    //更新生产规划
    @PostMapping(value = "/updateProduction", produces = "application/json;charset=UTF-8")
    public String updateProduction(@RequestBody productionProgramme productionProgramme, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if (productionProgramme.getProductionId() != null){
            int isHave = productionService.isHave(productionProgramme.getDeviceId(), productionProgramme.getMaterialCode(),productionProgramme.getProductionId());
            if (isHave <= 0){
                String deviceName = productionService.getDeviceName(productionProgramme.getDeviceId());
                String materialName = productionService.getMaterialName(productionProgramme.getMaterialCode());
                String processName = productionService.getProcessName(productionProgramme.getProcessCode());
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user  = userService.getUserById(userId);
                if (deviceName != null && materialName != null  && processName != null){
                    productionProgramme.setDeviceName(deviceName);
                    productionProgramme.setMaterialName(materialName);
                    productionProgramme.setProcessName(processName);
                    productionProgramme.setUpdateTime(df.format(new Date()));
                    productionProgramme.setUpdateUser(user.getNickname());
                    productionService.switchProduction(-99 ,1 , productionProgramme.getProductionId());
                    int update = productionService.addProduction(productionProgramme);
                    if (update > 0){
                        code = 200;
                        msg="修改成功!";
                        flag = true;
                    }else {
                        msg="修改失败!";
                        flag=false;
                    }
                }else if (deviceName == null){
                    msg="修改失败,设备编码不存在!";
                    flag=false;
                }else if (materialName == null){
                    msg="修改失败,物料不存在!";
                    flag=false;
                }else if (processName == null){
                    msg="修改失败,工序不存在!";
                    flag=false;
                }
            }else {
                msg="修改失败,设备ID物料编码重复!";
                flag=false;
            }
        }else {
            msg="修改失败!";
            flag=false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取设备列表
    @PostMapping(value = "/getProductionList", produces = "application/json;charset=UTF-8")
    public String getProductionList(@RequestBody SearchProcess searchProcess) {
        Map<String,Object> map = new HashMap<>();
        map.put("total" , productionService.getProductionListTotal(searchProcess.getEnable (),searchProcess.getDeviceId(),searchProcess.getDeviceName(),
                searchProcess.getProcessCode(),searchProcess.getProcessName(),searchProcess.getMaterialCode(),searchProcess.getMaterialName(),searchProcess.getUpdateUser(),
                searchProcess.getStartTime(),searchProcess.getEndTime()));//物料total
        List<productionProgramme> materialsList = productionService.getProductionList(searchProcess.getEnable (),searchProcess.getDeviceId(),searchProcess.getDeviceName(),
                searchProcess.getProcessCode(),searchProcess.getProcessName(),searchProcess.getMaterialCode(),searchProcess.getMaterialName(),searchProcess.getUpdateUser(),
                searchProcess.getStartTime(),searchProcess.getEndTime(),(searchProcess.getPage()-1)*10);//物料list
        map.put("data" , materialsList);

        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //查询框模糊查询
    @PostMapping(value = "/SearchProduction", produces = "application/json;charset=UTF-8")
    public String fuzzySearch(@RequestBody FuzzySearch fuzzySearch) {
        Map<String,Object> map = new HashMap<>();
        List<String> data = productionService.SearchProduction(fuzzySearch.getSearchKey() , fuzzySearch.getSearch());
        map.put("data" , data);
        code = 200;
        msg="获取成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

}
