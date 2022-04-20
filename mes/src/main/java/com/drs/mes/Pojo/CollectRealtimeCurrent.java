package com.drs.mes.Pojo;


public class CollectRealtimeCurrent {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private double I;


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


  public double getI() {
    return I;
  }

  public void setI(double I) {
    this.I = I;
  }

}
