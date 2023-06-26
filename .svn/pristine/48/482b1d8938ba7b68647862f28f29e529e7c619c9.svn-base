package com.javasm.controller;


import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.service.MenuService;
import com.javasm.service.UserService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author:
 * @className: LoginController
 * @description: 处理登录请求
 * @date: 2023/6/8 16:18
 * @since: 11
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求数据
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        // 调用业务层方法
        UserService userService = new UserServiceImpl();
        User loginUser = userService.queryByUserNameAndUserPwd(new User(userName, userPwd));
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (loginUser != null) {
            entity.setReturnCode(CodeAndMsg.LOGIN_SUCCESS.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.LOGIN_SUCCESS.getReturnMsg());
            HttpSession session = req.getSession();
            System.out.println("LoginController.sessionId=" + session.getId());
            // 向session对象上绑定登录用户的权限菜单数据(便于主界面侧栏数据呈现)
            MenuService menuService = new MenuServiceImpl();
            List<Menu> menuList = menuService.queryLoginMenuList(loginUser.getUserId());
            session.setAttribute("menuList", menuList);
            // 向session对象上绑定登录用户数据(便于做登录访问控制)
            session.setAttribute("loginUser", loginUser);
            // 向session对象上绑定登录用户二级权限地址(便于做权限访问控制)
            List<String> loginMenuUrl = menuService.queryLoginMenuUrl(loginUser.getUserId());
            session.setAttribute("loginMenuUrl", loginMenuUrl);
            // 设置最后一次的登录时间
            userService.editLoginTime(loginUser.getUserId());
        } else {
            entity.setReturnCode(CodeAndMsg.LOGIN_FAILURED.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.LOGIN_FAILURED.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }
}
