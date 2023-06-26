package com.javasm.entity.myEntity;


import java.util.Date;

public class ProductBasic {

  private long productBasicId;
  private long productCategoryId;
  private String productExamine;
  private String productName;
  private Date opDate;
  private String fundCurrency;
  private double growthRate;
  private long launchStatus;
  private double subscriptionRate;
  private double relativeManageCost;
  private double startAmount;
  private String chargeMode;
  private Date redemingCycle;
  private String redemingRate;
  private Date redemingLockup;
  private String checkStatus;


  public ProductBasic(long productBasicId, long productCategoryId, String productExamine, String productName, Date opDate, String fundCurrency, double growthRate, long launchStatus, double subscriptionRate, double relativeManageCost, double startAmount, String chargeMode, Date redemingCycle, String redemingRate, Date redemingLockup, String checkStatus) {
    this.productBasicId = productBasicId;
    this.productCategoryId = productCategoryId;
    this.productExamine = productExamine;
    this.productName = productName;
    this.opDate = opDate;
    this.fundCurrency = fundCurrency;
    this.growthRate = growthRate;
    this.launchStatus = launchStatus;
    this.subscriptionRate = subscriptionRate;
    this.relativeManageCost = relativeManageCost;
    this.startAmount = startAmount;
    this.chargeMode = chargeMode;
    this.redemingCycle = redemingCycle;
    this.redemingRate = redemingRate;
    this.redemingLockup = redemingLockup;
    this.checkStatus = checkStatus;
  }



  @Override
  public String toString() {
    return "ProductBasic{" +
            "productBasicId=" + productBasicId +
            ", productCategoryId=" + productCategoryId +
            ", productExamine='" + productExamine + '\'' +
            ", productName='" + productName + '\'' +
            ", opDate=" + opDate +
            ", fundCurrency='" + fundCurrency + '\'' +
            ", growthRate=" + growthRate +
            ", launchStatus=" + launchStatus +
            ", subscriptionRate=" + subscriptionRate +
            ", relativeManageCost=" + relativeManageCost +
            ", startAmount=" + startAmount +
            ", chargeMode='" + chargeMode + '\'' +
            ", redemingCycle=" + redemingCycle +
            ", redemingRate='" + redemingRate + '\'' +
            ", redemingLockup=" + redemingLockup +
            ", checkStatus='" + checkStatus + '\'' +
            '}';
  }

  public ProductBasic() {
  }

  public long getProductBasicId() {
    return productBasicId;
  }

  public void setProductBasicId(long productBasicId) {
    this.productBasicId = productBasicId;
  }

  public long getProductCategoryId() {
    return productCategoryId;
  }

  public void setProductCategoryId(long productCategoryId) {
    this.productCategoryId = productCategoryId;
  }

  public String getProductExamine() {
    return productExamine;
  }

  public void setProductExamine(String productExamine) {
    this.productExamine = productExamine;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Date getOpDate() {
    return opDate;
  }

  public void setOpDate(Date opDate) {
    this.opDate = opDate;
  }

  public String getFundCurrency() {
    return fundCurrency;
  }

  public void setFundCurrency(String fundCurrency) {
    this.fundCurrency = fundCurrency;
  }

  public double getGrowthRate() {
    return growthRate;
  }

  public void setGrowthRate(double growthRate) {
    this.growthRate = growthRate;
  }

  public long getLaunchStatus() {
    return launchStatus;
  }

  public void setLaunchStatus(long launchStatus) {
    this.launchStatus = launchStatus;
  }

  public double getSubscriptionRate() {
    return subscriptionRate;
  }

  public void setSubscriptionRate(double subscriptionRate) {
    this.subscriptionRate = subscriptionRate;
  }

  public double getRelativeManageCost() {
    return relativeManageCost;
  }

  public void setRelativeManageCost(double relativeManageCost) {
    this.relativeManageCost = relativeManageCost;
  }

  public double getStartAmount() {
    return startAmount;
  }

  public void setStartAmount(double startAmount) {
    this.startAmount = startAmount;
  }

  public String getChargeMode() {
    return chargeMode;
  }

  public void setChargeMode(String chargeMode) {
    this.chargeMode = chargeMode;
  }

  public Date getRedemingCycle() {
    return redemingCycle;
  }

  public void setRedemingCycle(Date redemingCycle) {
    this.redemingCycle = redemingCycle;
  }

  public String getRedemingRate() {
    return redemingRate;
  }

  public void setRedemingRate(String redemingRate) {
    this.redemingRate = redemingRate;
  }

  public Date getRedemingLockup() {
    return redemingLockup;
  }

  public void setRedemingLockup(Date redemingLockup) {
    this.redemingLockup = redemingLockup;
  }

  public String getCheckStatus() {
    return checkStatus;
  }

  public void setCheckStatus(String checkStatus) {
    this.checkStatus = checkStatus;
  }
}
