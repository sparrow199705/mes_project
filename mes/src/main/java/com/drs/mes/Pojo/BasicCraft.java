package com.drs.mes.Pojo;


public class BasicCraft {

  private int id;
  private String craftId;
  private String craftCode;
  private String productionVersions;
  private String materialCode;
  private String materialName;
  private int enable;
  private String createUser;
  private String createTime;
  private String updateUser;
  private String updateTime;
  private int isDeleted;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCraftId() {
    return craftId;
  }

  public void setCraftId(String craftId) {
    this.craftId = craftId;
  }

  public String getCraftCode() {
    return craftCode;
  }

  public void setCraftCode(String craftCode) {
    this.craftCode = craftCode;
  }

  public String getProductionVersions() {
    return productionVersions;
  }

  public void setProductionVersions(String productionVersions) {
    this.productionVersions = productionVersions;
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

  public int getEnable() {
    return enable;
  }

  public void setEnable(int enable) {
    this.enable = enable;
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

  public int getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(int isDeleted) {
    this.isDeleted = isDeleted;
  }
}
