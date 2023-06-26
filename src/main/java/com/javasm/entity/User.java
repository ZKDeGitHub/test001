package com.javasm.entity;


public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer roleId;
    private String regTime;
    private String loginTime;
    private Integer isValid;
    private Integer createUid;
    private String remark;
    private String headImg;
    private Integer versionId;

    public User() {
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName, String userPwd, Integer roleId, String regTime, Integer isValid, String headImg, Integer versionId) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.roleId = roleId;
        this.regTime = regTime;
        this.isValid = isValid;
        this.headImg = headImg;
        this.versionId = versionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", roleId=" + roleId +
                ", regTime='" + regTime + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", isValid=" + isValid +
                ", createUid=" + createUid +
                ", remark='" + remark + '\'' +
                ", headImg='" + headImg + '\'' +
                ", versionId=" + versionId +
                '}';
    }
}
