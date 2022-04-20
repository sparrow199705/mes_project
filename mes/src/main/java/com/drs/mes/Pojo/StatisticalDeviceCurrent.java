package com.drs.mes.Pojo;


public class StatisticalDeviceCurrent {

  private long id;
  private String deviceId;
  private String deviceName;
  private long controllerId;
  private String day;
  private long hour;
  private long minute;
  private double charge;
  private double currentPeak;
  private double currentAverage;


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


  public long getMinute() {
    return minute;
  }

  public void setMinute(long minute) {
    this.minute = minute;
  }


  public double getCharge() {
    return charge;
  }

  public void setCharge(double charge) {
    this.charge = charge;
  }


  public double getCurrentPeak() {
    return currentPeak;
  }

  public void setCurrentPeak(double currentPeak) {
    this.currentPeak = currentPeak;
  }


  public double getCurrentAverage() {
    return currentAverage;
  }

  public void setCurrentAverage(double currentAverage) {
    this.currentAverage = currentAverage;
  }

}
