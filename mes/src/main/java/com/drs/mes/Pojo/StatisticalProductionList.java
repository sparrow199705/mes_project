package com.drs.mes.Pojo;


public class StatisticalProductionList {

  private long id;
  private String deviceId;
  private String deviceName;
  private String day;
  private long hour;
  private String materialCode;
  private String materialName;
  private long output;
  private int capacity;
  private double finish;

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public double getFinish() {
    return finish;
  }

  public void setFinish(double finish) {
    this.finish = finish;
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


  public String getDay() {
    return day;
  }

  public void setDay(String day) {
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


  public long getOutput() {
    return output;
  }

  public void setOutput(long output) {
    this.output = output;
  }

}
