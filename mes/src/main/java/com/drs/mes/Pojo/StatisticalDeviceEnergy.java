package com.drs.mes.Pojo;


public class StatisticalDeviceEnergy {

  private long id;
  private String deviceId;
  private String deviceName;
  private String day;
  private long hour;
  private double charge;
  private double iPeak;
  private double iAverage;
  private double U;
  private double ep;


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


  public double getCharge() {
    return charge;
  }

  public void setCharge(double charge) {
    this.charge = charge;
  }


  public double getIPeak() {
    return iPeak;
  }

  public void setIPeak(double iPeak) {
    this.iPeak = iPeak;
  }


  public double getIAverage() {
    return iAverage;
  }

  public void setIAverage(double iAverage) {
    this.iAverage = iAverage;
  }


  public double getU() {
    return U;
  }

  public void setU(double U) {
    this.U = U;
  }


  public double getEp() {
    return ep;
  }

  public void setEp(double ep) {
    this.ep = ep;
  }

}
