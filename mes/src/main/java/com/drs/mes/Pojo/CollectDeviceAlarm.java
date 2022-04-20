package com.drs.mes.Pojo;


public class CollectDeviceAlarm {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private String plcPoint;
  private long plcPointState;
  private String alarmDescription;
  private String alarmType;
  private String startTime;
  private String endTime;


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


  public String getPlcPoint() {
    return plcPoint;
  }

  public void setPlcPoint(String plcPoint) {
    this.plcPoint = plcPoint;
  }


  public long getPlcPointState() {
    return plcPointState;
  }

  public void setPlcPointState(long plcPointState) {
    this.plcPointState = plcPointState;
  }


  public String getAlarmDescription() {
    return alarmDescription;
  }

  public void setAlarmDescription(String alarmDescription) {
    this.alarmDescription = alarmDescription;
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

}
