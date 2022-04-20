package com.drs.mes.Pojo;


public class productionProgramme {

  private long id;
  private String deviceId;
  private String deviceName;
  private String processCode;
  private String processName;
  private String materialCode;
  private String materialName;
  private long planCapacity;
  private long enable;
  private long isDeleted;
  private String updateUser;
  private String updateTime;
  private String productionId;

  public String getProductionId() {
    return productionId;
  }

  public void setProductionId(String productionId) {
    this.productionId = productionId;
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


  public String getProcessCode() {
    return processCode;
  }

  public void setProcessCode(String processCode) {
    this.processCode = processCode;
  }


  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }


  public String getMaterialCode() {
    return materialCode;
  }

  public void setMaterialCode(String materialCode) {
    this.materialCode = materialCode;
  }


  public String getMaterialName() {
    return materialName;
  }

  public void setMaterialName(String materialName) {
    this.materialName = materialName;
  }


  public long getPlanCapacity() {
    return planCapacity;
  }

  public void setPlanCapacity(long planCapacity) {
    this.planCapacity = planCapacity;
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
