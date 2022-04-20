package com.drs.mes.Pojo;


public class BasicMaterials {

  private long id;
  private String materialCode;
  private String materialName;
  private String materialType;
  private String materialSeries;
  private String unit;
  private long enable;
  private long isDeleted;
  private String createUser;
  private String createTime;
  private String updateUser;
  private String updateTime;
  private String materialId;

  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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


  public String getMaterialType() {
    return materialType;
  }

  public void setMaterialType(String materialType) {
    this.materialType = materialType;
  }


  public String getMaterialSeries() {
    return materialSeries;
  }

  public void setMaterialSeries(String materialSeries) {
    this.materialSeries = materialSeries;
  }


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public long getEnable() {
    return enable;
  }

  public void setEnable(long enable) {
    this.enable = enable;
  }


  public long getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(long isDeleted) {
    this.isDeleted = isDeleted;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}
