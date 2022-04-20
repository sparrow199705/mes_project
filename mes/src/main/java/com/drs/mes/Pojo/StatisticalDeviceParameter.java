package com.drs.mes.Pojo;


public class StatisticalDeviceParameter {

  private long id;
  private String deviceId;
  private String deviceName;
  private long controllerId;
  private String updateTime;
  private long effectiveIdentification;
  private String parameterCode;
  private String parameterName;
  private String parameterValue;
  private long valueDataType;
  private String parameterUnit;


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


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }


  public long getEffectiveIdentification() {
    return effectiveIdentification;
  }

  public void setEffectiveIdentification(long effectiveIdentification) {
    this.effectiveIdentification = effectiveIdentification;
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


  public String getParameterUnit() {
    return parameterUnit;
  }

  public void setParameterUnit(String parameterUnit) {
    this.parameterUnit = parameterUnit;
  }

}
