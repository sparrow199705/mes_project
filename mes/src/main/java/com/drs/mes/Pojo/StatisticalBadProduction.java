package com.drs.mes.Pojo;


public class StatisticalBadProduction {

  private long id;
  private String deviceId;
  private String deviceName;
  private long controllerId;
  private java.sql.Date day;
  private long hour;
  private String materialCode;
  private String materialName;
  private String defectiveType;
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


  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }


  public long getControllerId() {
    return controllerId;
  }

  public void setControllerId(long controllerId) {
    this.controllerId = controllerId;
  }


  public java.sql.Date getDay() {
    return day;
  }

  public void setDay(java.sql.Date day) {
    this.day = day;
  }


  public long getHour() {
    return hour;
  }

  public void setHour(long hour) {
    this.hour = hour;
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


  public String getDefectiveType() {
    return defectiveType;
  }

  public void setDefectiveType(String defectiveType) {
    this.defectiveType = defectiveType;
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
