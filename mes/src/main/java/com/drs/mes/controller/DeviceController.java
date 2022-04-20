package com.drs.mes.controller;

import com.alibaba.fastjson.JSON;
import com.drs.mes.Pojo.*;
import com.drs.mes.service.DeviceService;
import com.drs.mes.service.HomePageService;
import com.drs.mes.service.UserService;
import com.drs.mes.util.DateUtil;
import com.drs.mes.util.TokenUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin/device")
public class DeviceController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(DeviceController.class);

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    @Autowired
    DeviceService deviceService;

    @Autowired
    private UserService userService;

    @Autowired
    private HomePageService homePageService;

    //添加设备
    @PostMapping(value = "/addDevice", produces = "application/json;charset=UTF-8")
    public String addMaterial(@RequestBody List<BasicDevice> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        int inset = 0;
        int error = 0;
        String errCod = "编码重复";
        for (BasicDevice basicDevice : list) {
            int isHave = deviceService.findDeviceById(basicDevice.getDeviceId());
            if (isHave == 0) {//判断物料编码是否重复
                String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
                int id = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(id);
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                basicDevice.setUUID(uuid);
                basicDevice.setCreateTime(df.format(new Date()));
                basicDevice.setCreateUser(user.getNickname());
                basicDevice.setUpdateTime(df.format(new Date()));
                basicDevice.setUpdateUser(user.getNickname());
                deviceService.addDevice(basicDevice);
                inset ++;
            }else {
                error++;
                errCod= errCod +","+basicDevice.getDeviceId();
            }
        }
        if (inset > 0){
            code = 200;
            msg="成功添加:"+inset+"条!";
            if (error>0)
                msg="成功添加:"+inset+"条,设备编码重复"+error+"条!"+errCod;
            flag = true;
        }else {
            msg="添加失败,编码重复!";
            flag=false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/switchDevice", produces = "application/json;charset=UTF-8")
    public String switchDevice(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        int enable = -99;
        int isDeleted = -99;
        if (post.containsKey("enable")){//物料开关
            enable =(int) post.get("enable");
        }
        if (post.containsKey("isDeleted")){//物料删除
            isDeleted = (int)post.get("isDeleted");
        }
        String deviceId=post.get("UUID").toString();
        String [] deviceIds = deviceId.split(",");
        int update = 0;
        for(int a = 0;a<deviceIds.length;a++){
            deviceService.switchDevice(enable , isDeleted , deviceIds[a]);
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
    @PostMapping(value = "/updateDevice", produces = "application/json;charset=UTF-8")
    public String updateDevice(@RequestBody BasicDevice basicDevice, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if (basicDevice.getUUID() != null) {
            int isHave = deviceService.findUpdate(basicDevice.getDeviceId(), basicDevice.getUUID());
            if (isHave == 0) {
                BasicDevice oldDevice = deviceService.getDevice(basicDevice.getUUID());
                int userId = Integer.parseInt(TokenUtil.verify(request.getHeader("token")));
                User user = userService.getUserById(userId);
                basicDevice.setCreateTime(oldDevice.getCreateTime());
                basicDevice.setCreateUser(oldDevice.getCreateUser());
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                basicDevice.setUpdateTime(df.format(new Date()));
                basicDevice.setUpdateUser(user.getNickname());
                deviceService.switchDevice(-99, 1, oldDevice.getUUID());
                int update = deviceService.addDevice(basicDevice);
                deviceService.updatePro(basicDevice.getDeviceId(), basicDevice.getDeviceName(), oldDevice.getDeviceId());
                if (update > 0) {
                    code = 200;
                    msg = "修改成功!";
                    flag = true;
                } else {
                    msg = "修改失败!";
                    flag = false;
                }
            } else {
                msg = "修改失败,设备编号已存在!";
                flag = false;
            }
        }else {
            msg = "修改失败,缺少设备ID!";
            flag = false;
        }
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    //查询框模糊查询
    @PostMapping(value = "/SearchDevice", produces = "application/json;charset=UTF-8")
    public String fuzzySearch(@RequestBody FuzzySearch fuzzySearch) {
        Map<String,Object> map = new HashMap<>();
        List<String> data = deviceService.fuzzySearch(fuzzySearch.getSearchKey() , fuzzySearch.getSearch());
        map.put("data" , data);
        code = 200;
        msg="获取成功!";
        flag = true;
        String json = JSON.toJSONString(ResState(flag,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


    //获取设备列表
    @PostMapping(value = "/getDeviceList", produces = "application/json;charset=UTF-8")
    public String getDeviceList(@RequestBody SearchDevice searchDevice) {
        Map<String,Object> map = new HashMap<>();
        List<BasicDevice> materialsList = deviceService.getDeviceList(searchDevice.getEnable(),searchDevice.getDeviceId(),
                searchDevice.getDeviceName(),searchDevice.getDeviceType(),searchDevice.getDeviceCategory(),
                searchDevice.getUpdateUser(), searchDevice.getStartTime(),searchDevice.getEndTime(),(searchDevice.getPage()-1)*10);//物料list
        map.put("data" , materialsList);
        map.put("total" , deviceService.getDeviceListTotal(searchDevice.getEnable(),searchDevice.getDeviceId(),
                searchDevice.getDeviceName(),searchDevice.getDeviceType(),searchDevice.getDeviceCategory(),
                searchDevice.getUpdateUser(), searchDevice.getStartTime(), searchDevice.getEndTime()));//物料total
        code = 200;
        msg="获取成功!";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getFiveSecond", produces = "application/json;charset=UTF-8")
    public String get5Second(@RequestBody Map<String , Object> post) {
        Map<String,Object> map = new HashMap<>();
        String deviceId;
        if (post.containsKey("deviceId") && post.get("deviceId") != null && post.get("deviceId") != ""){
            deviceId = post.get("deviceId").toString();
        }else {
            deviceId = deviceService.getDeviceId();
        }

        //设备关键指标
        Map<String , Object> deviceMap = deviceService.getDeviceByDeviceId(deviceId);//设备名
        // 生产产量
        if (deviceMap == null){
            deviceMap = new HashMap<>();
            deviceMap.put("OEE" , 0);
            deviceMap.put("actualSpeed" , 0);
            deviceMap.put("deviceName" , deviceService.getDeviceName(deviceId));
        }
        int output = deviceService.getDeviceOutput(deviceId);
        int badOutput = deviceService.getDeviceDayBad(deviceId);
        double badRate=0;
        if (output != 0){
            badRate = (double)badOutput / ((double)badOutput + (double)output) *100;
        }
        DecimalFormat df   = new DecimalFormat("######0.00");//保留两位小数
        badRate = Double.parseDouble(df.format(badRate));
        deviceMap.put("output" ,output);//生产产量
        deviceMap.put("badRate" ,badRate);//不良率
        deviceMap.put("EP" , deviceService.getDeviceEP(deviceId));
        if (deviceService.getDeviceState(deviceId) != null && deviceService.getDeviceState(deviceId) !=""){
            deviceMap.put("deviceState" , deviceService.getDeviceState(deviceId));//设备运行状态
        }else {
            deviceMap.put("deviceState" , "离线");//设备运行状态
        }
        map.put("device" , deviceMap);

        //总设备数
        int deviceNum = homePageService.getDeviceNum();
        List<Map<String , Object>> onlineDeviceList = homePageService.getOnlineDevice();
        int deviceRun = 0 ; //运行
        int pause = 0; //暂停
        int standby = 0;//待机
        int off = 0; //离线
        for (Map<String , Object> onlineDeviceMap : onlineDeviceList){
            String state = onlineDeviceMap.get("state").toString();
            if (state.equals("运行")){
                deviceRun = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }else if (state.equals("暂停")){
                pause = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }else if (state.equals("待机")){
                standby = Integer.parseInt(String.valueOf(onlineDeviceMap.get("num")));
            }
        }
        off =(deviceNum - deviceRun - pause - standby);
        map.put("deviceNum" , deviceNum);
        map.put("deviceRun" , deviceRun);
        map.put("devicePause" , pause);
        map.put("deviceStandby" , standby);
        map.put("deviceOff" , off);
        //获取全部设备
        List<Map<String , Object>> deviceList = deviceService.getAllDevice();
        //设备状态
        List<Map<String , Object>> deviceState = new ArrayList<>();
        for (Map<String , Object> deviceStateMap : deviceList){
            String state = deviceService.getDeviceState(deviceStateMap.get("deviceId").toString());
            if (state != null && state !=""){
                deviceStateMap.put("deviceState" , state);//设备运行状态
            }else {
                deviceStateMap.put("deviceState" , "离线");//查询不到为离线
            }
            deviceState.add(deviceStateMap);
        }
        map.put("deviceState" , deviceState);
        code = 200;
        msg="获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }

    @PostMapping(value = "/getOneMinute", produces = "application/json;charset=UTF-8")
    public String getOneMinute(@RequestBody Map<String , Object> post) throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        String deviceId;
        if (post.containsKey("deviceId") && post.get("deviceId") != null && post.get("deviceId") != ""){
            deviceId = post.get("deviceId").toString();
        }else {
            deviceId = deviceService.getDeviceId();
        }
        //设备关键参数
        List<Map<String , Object>> parameterList = deviceService.getDeviceParameter(deviceId);
        map.put("parameter" , parameterList);
        //设备OEE
        Map<String , Object> OEE = new HashMap<>();
        for (int i=0 ; i <=23 ; i++){
            String hour = i+"";
            double douOEE = deviceService.getOEEHour(i ,deviceId)*100;
            DecimalFormat df   = new DecimalFormat("######0.00");//保留两位小数
            douOEE = Double.parseDouble(df.format(douOEE));
            OEE.put(hour , douOEE);
        }
        map.put("OEE" , OEE);
        code = 200;
        df = new SimpleDateFormat("HH");//设置日期格式
        int hour = Integer.parseInt(df.format(new Date()));//获取当前小时
        df = new SimpleDateFormat("mm");//设置日期格式
        int minute =Integer.parseInt(df.format(new Date()));//获取当前分钟
        Map<String , Object> currentMap = new HashMap<>();
        double current =0;
        for (int i = minute-4 ; i<= minute ; i++) {
            current = deviceService.getCurrent(hour,i,deviceId);
            currentMap.put(i+"" , current);
        }
        map.put("current" , currentMap);
        //月报警次数统计
        List<Map<String , Object>> alarmType = deviceService.getAlarmType(deviceId);
        map.put("alarmType" ,alarmType);
        map.put("alarm",deviceService.getAlarm(deviceId));//设备报警
        msg="获取成功";
        String json = JSON.toJSONString(ResState(true,msg,map,code),allowJsonNull,datetimeformat);
        map.clear();
        return json;
    }


}
