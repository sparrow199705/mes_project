package com.drs.mes.Pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BasicDevice {

  private long id;
  private String deviceId;
  private String deviceName;
  private String deviceCategory;
  private String deviceType;
  private long deviceSpeed;
  private long enable;
  private long isDeleted;
  private String createUser;
  private String createTime;
  private String updateUser;
  private String updateTime;

  @JsonProperty("UUID")//传参
  @JSONField(name = "UUID")//发送
  private String UUID;

  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }


  public String getDeviceCategory() {
    return deviceCategory;
  }

  public void setDeviceCategory(String deviceCategory) {
    this.deviceCategory = deviceCategory;
  }


  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }


  public long getDeviceSpeed() {
    return deviceSpeed;
  }

  public void setDeviceSpeed(long deviceSpeed) {
    this.deviceSpeed = deviceSpeed;
  }


  public long getEnable() {
    return enable;
  }

  public void setEnable(long enable) {
    this.enable = enable;
  }


  public long getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(long isDeleted) {
    this.isDeleted = isDeleted;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
