package com.drs.mes.Pojo;


public class CollectDeviceProduction {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private String state;
  private double startupTime;
  private double runningTime;
  private double downTime;
  private double scheduledDownTime;
  private double oee;
  private String lastResetTime;
  private long qualifiedProducts;
  private long defectiveProducts;
  private double qualifiedRate;
  private long actualSpeed;
  private long theorySpeed;


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


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public double getStartupTime() {
    return startupTime;
  }

  public void setStartupTime(double startupTime) {
    this.startupTime = startupTime;
  }


  public double getRunningTime() {
    return runningTime;
  }

  public void setRunningTime(double runningTime) {
    this.runningTime = runningTime;
  }


  public double getDownTime() {
    return downTime;
  }

  public void setDownTime(double downTime) {
    this.downTime = downTime;
  }


  public double getScheduledDownTime() {
    return scheduledDownTime;
  }

  public void setScheduledDownTime(double scheduledDownTime) {
    this.scheduledDownTime = scheduledDownTime;
  }


  public double getOee() {
    return oee;
  }

  public void setOee(double oee) {
    this.oee = oee;
  }


  public String getLastResetTime() {
    return lastResetTime;
  }

  public void setLastResetTime(String lastResetTime) {
    this.lastResetTime = lastResetTime;
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


  public double getQualifiedRate() {
    return qualifiedRate;
  }

  public void setQualifiedRate(double qualifiedRate) {
    this.qualifiedRate = qualifiedRate;
  }


  public long getActualSpeed() {
    return actualSpeed;
  }

  public void setActualSpeed(long actualSpeed) {
    this.actualSpeed = actualSpeed;
  }


  public long getTheorySpeed() {
    return theorySpeed;
  }

  public void setTheorySpeed(long theorySpeed) {
    this.theorySpeed = theorySpeed;
  }

}
