package com.ahuan.quartz.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodInfoEntity implements Serializable {
    private Integer bgiId;

    private String bgiName;

    private BigDecimal bgiPrice;

    private String bgiUnit;

    private static final long serialVersionUID = 1L;

    public Integer getBgiId() {
        return bgiId;
    }

    public void setBgiId(Integer bgiId) {
        this.bgiId = bgiId;
    }

    public String getBgiName() {
        return bgiName;
    }

    public void setBgiName(String bgiName) {
        this.bgiName = bgiName == null ? null : bgiName.trim();
    }

    public BigDecimal getBgiPrice() {
        return bgiPrice;
    }

    public void setBgiPrice(BigDecimal bgiPrice) {
        this.bgiPrice = bgiPrice;
    }

    public String getBgiUnit() {
        return bgiUnit;
    }

    public void setBgiUnit(String bgiUnit) {
        this.bgiUnit = bgiUnit == null ? null : bgiUnit.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bgiId=").append(bgiId);
        sb.append(", bgiName=").append(bgiName);
        sb.append(", bgiPrice=").append(bgiPrice);
        sb.append(", bgiUnit=").append(bgiUnit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}