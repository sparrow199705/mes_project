package com.drs.mes.Pojo;

public class CraftFind {
    private int enable ;
    private String craftCode ;
    private String productionVersions;
    private String materialCode ;
    private String materialName;
    private String updateUser ;
    private String startTime;
    private String endTime;
    private int page;

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
