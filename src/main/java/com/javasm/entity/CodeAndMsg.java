package com.javasm.entity;



/**
 * @author:
 * @className: CodeAndMsg
 * @description: 状态码和描述信息建立绑定关系
 * @date: 2023/6/8 15:19
 * @since: 11
 */

public enum CodeAndMsg {
    LOGIN_SUCCESS(2000, "登录成功"),
    LOGIN_FAILURED(4000, "登录失败"),
    SUCCESS_QUERY(2001, "成功查询到数据"),
    FAILURED_QUERY(4001, "没有查询到数据"),
    SUCCESS_OPERATE(2002,"操作成功"),
    FAILURED_OPERATE(4002,"操作失败"),
    DATA_ISUSE(4003,"编号被占用"),
    DATA_ISUPDATE(4004,"数据不是最新数据"),
    NO_LOGIN(4005, "没有登录"),
    NO_AUTH(4006,"没有权限");

    private Integer returnCode;
    private String returnMsg;

    CodeAndMsg(Integer returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    CodeAndMsg() {
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
