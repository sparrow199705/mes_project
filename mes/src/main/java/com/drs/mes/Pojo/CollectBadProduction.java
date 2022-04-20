package com.drs.mes.Pojo;


public class CollectBadProduction {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private String badType;
  private long qualifiedProducts;
  private long defectiveProducts;


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


  public long getControllerId() {
    return controllerId;
  }

  public void setControllerId(long controllerId) {
    this.controllerId = controllerId;
  }


  public String getCollectTime() {
    return collectTime;
  }

  public void setCollectTime(String collectTime) {
    this.collectTime = collectTime;
  }


  public String getBadType() {
    return badType;
  }

  public void setBadType(String badType) {
    this.badType = badType;
  }


  public long getQualifiedProducts() {
    return qualifiedProducts;
  }

  public void setQualifiedProducts(long qualifiedProducts) {
    this.qualifiedProducts = qualifiedProducts;
  }


  public long getDefectiveProducts() {
    return defectiveProducts;
  }

  public void setDefectiveProducts(long defectiveProducts) {
    this.defectiveProducts = defectiveProducts;
  }

}
