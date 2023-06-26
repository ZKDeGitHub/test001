package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.ReturnEntity;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:
 * @className: LogoutController
 * @description:
 * @date: 2023/6/19 17:19
 * @since: 11
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 移除session对象上绑定值
        HttpSession session = req.getSession();
        session.removeAttribute("menuList");
        session.removeAttribute("loginUser");
        session.removeAttribute("loginMenuUrl");
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
        entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }
}
