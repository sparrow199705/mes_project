package com.drs.mes.Pojo;


public class StatisticalDeviceAlarm {

  private long id;
  private String deviceId;
  private String deviceName;
  private long controllerId;
  private java.sql.Date day;
  private long hour;
  private String alarmCode;
  private String alarmType;
  private String startTime;
  private String endTime;
  private double alarmTimeLength;
  private long alarmNum;


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


  public String getAlarmCode() {
    return alarmCode;
  }

  public void setAlarmCode(String alarmCode) {
    this.alarmCode = alarmCode;
  }


  public String getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(String alarmType) {
    this.alarmType = alarmType;
  }


  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  public double getAlarmTimeLength() {
    return alarmTimeLength;
  }

  public void setAlarmTimeLength(double alarmTimeLength) {
    this.alarmTimeLength = alarmTimeLength;
  }


  public long getAlarmNum() {
    return alarmNum;
  }

  public void setAlarmNum(long alarmNum) {
    this.alarmNum = alarmNum;
  }

}
