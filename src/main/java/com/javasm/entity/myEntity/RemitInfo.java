package com.javasm.entity.myEntity;


public class RemitInfo {

  private long remitId;
  private String bankName;
  private String bankCode;
  private String swiftCode;
  private String cnapsCode;
  private String bankArea;
  private String bankCity;
  private String payeeName;
  private String payeeAccountCode;
  private String payeeAddress;
  private String assetManagement;
  private long productCategoryId;

  public RemitInfo(long remitId, String bankName, String bankCode, String swiftCode, String cnapsCode, String bankArea, String bankCity, String payeeName, String payeeAccountCode, String payeeAddress, String assetManagement, long productCategoryId) {
    this.remitId = remitId;
    this.bankName = bankName;
    this.bankCode = bankCode;
    this.swiftCode = swiftCode;
    this.cnapsCode = cnapsCode;
    this.bankArea = bankArea;
    this.bankCity = bankCity;
    this.payeeName = payeeName;
    this.payeeAccountCode = payeeAccountCode;
    this.payeeAddress = payeeAddress;
    this.assetManagement = assetManagement;
    this.productCategoryId = productCategoryId;
  }

  public RemitInfo() {
  }

  @Override
  public String toString() {
    return "RemitInfo{" +
            "remitId=" + remitId +
            ", bankName='" + bankName + '\'' +
            ", bankCode='" + bankCode + '\'' +
            ", swiftCode='" + swiftCode + '\'' +
            ", cnapsCode='" + cnapsCode + '\'' +
            ", bankArea='" + bankArea + '\'' +
            ", bankCity='" + bankCity + '\'' +
            ", payeeName='" + payeeName + '\'' +
            ", payeeAccountCode='" + payeeAccountCode + '\'' +
            ", payeeAddress='" + payeeAddress + '\'' +
            ", assetManagement='" + assetManagement + '\'' +
            ", productCategoryId=" + productCategoryId +
            '}';
  }

  public long getRemitId() {
    return remitId;
  }

  public void setRemitId(long remitId) {
    this.remitId = remitId;
  }


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }


  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }


  public String getSwiftCode() {
    return swiftCode;
  }

  public void setSwiftCode(String swiftCode) {
    this.swiftCode = swiftCode;
  }


  public String getCnapsCode() {
    return cnapsCode;
  }

  public void setCnapsCode(String cnapsCode) {
    this.cnapsCode = cnapsCode;
  }


  public String getBankArea() {
    return bankArea;
  }

  public void setBankArea(String bankArea) {
    this.bankArea = bankArea;
  }


  public String getBankCity() {
    return bankCity;
  }

  public void setBankCity(String bankCity) {
    this.bankCity = bankCity;
  }


  public String getPayeeName() {
    return payeeName;
  }

  public void setPayeeName(String payeeName) {
    this.payeeName = payeeName;
  }


  public String getPayeeAccountCode() {
    return payeeAccountCode;
  }

  public void setPayeeAccountCode(String payeeAccountCode) {
    this.payeeAccountCode = payeeAccountCode;
  }


  public String getPayeeAddress() {
    return payeeAddress;
  }

  public void setPayeeAddress(String payeeAddress) {
    this.payeeAddress = payeeAddress;
  }


  public String getAssetManagement() {
    return assetManagement;
  }

  public void setAssetManagement(String assetManagement) {
    this.assetManagement = assetManagement;
  }


  public long getProductCategoryId() {
    return productCategoryId;
  }

  public void setProductCategoryId(long productCategoryId) {
    this.productCategoryId = productCategoryId;
  }

}
