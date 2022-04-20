package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.BasicMaterials;
import com.drs.mes.Pojo.FuzzySearch;
import com.drs.mes.Pojo.SearchMaterial;
import com.drs.mes.Pojo.User;
import com.drs.mes.service.MaterialService;
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
@RequestMapping("/admin/material")
public class MaterialController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;
    @Autowired
    private UserService userService;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    //获取物料列表
    @PostMapping(value = "/getMaterialList", produces = "application/json;charset=UTF-8")
    public String getMaterialList(@RequestBody SearchMaterial searchMaterial) {
        Map<String,Object> map = new HashMap<>();
        List<BasicMaterials> materialsList = materialService.getMaterialList(searchMaterial.getEnable(),
                searchMaterial.getIsDeleted(),searchMaterial.getMaterialCode(),searchMaterial.getMaterialName(),searchMaterial.getMaterialType(),
                searchMaterial.getMaterialSeries(), searchMaterial.getUpdateUser(), searchMaterial.getStartTime(), searchMaterial.getEndTime(),
                (searchMaterial.getPage()-1)*10);//物料list
        map.put("data" , materialsList);
        map.put("total" , materialService.getMaterialListTotal(searchMaterial.getEnable(),
                searchMaterial.getIsDeleted(),searchMaterial.getMaterialCode(),searchMaterial.getMaterialName(),searchMaterial.getMaterialType(),
                searchMaterial.getMaterialSeries(),searchMaterial.getUpdateUser(),searchMaterial.getStartTime(), searchMaterial.getEndTime()));//物料total
        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //添加物料
    @PostMapping(value = "/addMaterial", produces = "application/json;charset=UTF-8")
    public String addMaterial(@RequestBody List<BasicMaterials> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int inset = 0;
        int error = 0;
        String errCod = "编码重复";
        for (BasicMaterials basicMaterial : list) {
            int isRepetition = materialService.findMaterialByCode(basicMaterial.getMaterialCode());
            if (isRepetition == 0) {//判断物料编码是否重复
                String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                int id = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(id);
                basicMaterial.setCreateTime(df.format(new Date()));
                basicMaterial.setCreateUser(user.getNickname());
                basicMaterial.setUpdateTime(df.format(new Date()));
                basicMaterial.setUpdateUser(user.getNickname());
                basicMaterial.setMaterialId(uuid);
                materialService.addMaterial(basicMaterial);
                inset ++;
            }else {
                error++;
                errCod= errCod +","+basicMaterial.getMaterialCode();
            }
        }
            if (inset > 0){
                code = 200;
                msg="成功添加:"+inset+"条!";
                if (error>0)
                    msg="成功添加:"+inset+"条,物料编码重复"+error+"条!"+errCod;
                flag = true;
            }else {
                msg="添加失败,编码重复!";
                flag=false;
            }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //物料开关与删除
    @PostMapping(value = "/switchMaterial", produces = "application/json;charset=UTF-8")
    public String switchMaterial(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int enable = -99;
        int isDeleted = -99;
        if (post.containsKey("enable")){//物料开关
            enable =(int) post.get("enable");
        }
        if (post.containsKey("isDeleted")){//物料删除
            isDeleted = (int)post.get("isDeleted");
        }
        String materialId=post.get("materialId").toString();
        String [] materialIds = materialId.split(",");
        int update = 0;
        for(int a = 0;a<materialIds.length;a++){
            materialService.switchMaterial(enable , isDeleted , materialIds[a]);
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

    //更新物料
    @PostMapping(value = "/updateMaterial", produces = "application/json;charset=UTF-8")
    public String updateMaterial(@RequestBody BasicMaterials basicMaterials, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if (basicMaterials.getMaterialId() != null) {
            int isHave = materialService.findUpdate(basicMaterials.getMaterialCode(), basicMaterials.getMaterialId());//物料编码是否重复
            if (isHave == 0) {
                BasicMaterials oldMaterial = materialService.getMaterial(basicMaterials.getMaterialId());
                materialService.switchMaterial(-99, 1, basicMaterials.getMaterialId());
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(userId);
                basicMaterials.setCreateUser(oldMaterial.getCreateUser());
                basicMaterials.setCreateTime(oldMaterial.getCreateTime());
                basicMaterials.setUpdateTime(df.format(new Date()));
                basicMaterials.setUpdateUser(user.getNickname());
                materialService.switchMaterial(-99, 1, oldMaterial.getMaterialId());
                materialService.updatePro(basicMaterials.getMaterialCode(),basicMaterials.getMaterialName(),oldMaterial.getMaterialCode());
                materialService.updateCraft(basicMaterials.getMaterialCode(),basicMaterials.getMaterialName(),oldMaterial.getMaterialCode());
                int update = materialService.addMaterial(basicMaterials);
                if (update > 0) {
                    code = 200;
                    msg = "修改成功!";
                    flag = true;
                } else {
                    msg = "修改失败!";
                    flag = false;
                }
            } else {
                msg = "修改失败,物料编码重复!";
                flag = false;
            }
        }else {
            msg="物料ID不能为空";
            flag = false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //查询框模糊查询
    @PostMapping(value = "/SearchMaterial", produces = "application/json;charset=UTF-8")
    public String fuzzySearch(@RequestBody FuzzySearch fuzzySearch, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        List<String> data = materialService.fuzzySearch(fuzzySearch.getSearchKey() , fuzzySearch.getSearch());
        map.put("data" , data);
        code = 200;
        msg="获取成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


}
