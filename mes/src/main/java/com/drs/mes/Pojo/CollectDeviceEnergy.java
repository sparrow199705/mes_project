package com.drs.mes.Pojo;


public class CollectDeviceEnergy {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private double ep;
  private double I;
  private double U;
  private double lc;


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


  public double getEp() {
    return ep;
  }

  public void setEp(double ep) {
    this.ep = ep;
  }


  public double getI() {
    return I;
  }

  public void setI(double I) {
    this.I = I;
  }


  public double getU() {
    return U;
  }

  public void setU(double U) {
    this.U = U;
  }


  public double getLc() {
    return lc;
  }

  public void setLc(double lc) {
    this.lc = lc;
  }

}
