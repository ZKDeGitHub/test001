package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.utils.CORSUtils;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:
 * @className: MainController
 * @description: 处理系统主界面请求
 * @date: 2023/6/15 9:47
 * @since: 11
 */
@WebServlet("/main")
public class MainController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("MainController.sessionId=" + session.getId());
        // 从session对象上获取登录用户的权限菜单数据
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (menuList != null && menuList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            // 从session对象上获取登录用户的名称
            User loginUser = (User) session.getAttribute("loginUser");
            String loginUserName = loginUser.getUserName();
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("menuList", menuList);
            returnMap.put("loginUserName", loginUserName);
            entity.setReturnData(returnMap);
        } else {
            entity.setReturnCode(CodeAndMsg.NO_LOGIN.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.NO_LOGIN.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }
}
