package com.drs.mes.Pojo;


public class CollectDeviceParameter {

  private long id;
  private String deviceId;
  private long controllerId;
  private String collectTime;
  private String parameterCode;
  private String parameterName;
  private String parameterValue;
  private long valueDataType;
  private long parameterUnit;


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


  public String getParameterCode() {
    return parameterCode;
  }

  public void setParameterCode(String parameterCode) {
    this.parameterCode = parameterCode;
  }


  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }


  public String getParameterValue() {
    return parameterValue;
  }

  public void setParameterValue(String parameterValue) {
    this.parameterValue = parameterValue;
  }


  public long getValueDataType() {
    return valueDataType;
  }

  public void setValueDataType(long valueDataType) {
    this.valueDataType = valueDataType;
  }


  public long getParameterUnit() {
    return parameterUnit;
  }

  public void setParameterUnit(long parameterUnit) {
    this.parameterUnit = parameterUnit;
  }

}
