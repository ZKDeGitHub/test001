package com.javasm.controller;

import com.javasm.entity.*;
import com.javasm.service.MenuService;
import com.javasm.service.UserMenuService;
import com.javasm.service.UserService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.service.impl.UserMenuServiceImpl;
import com.javasm.service.impl.UserServiceImpl;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:
 * @className: UserController
 * @description:
 * @date: 2023/6/15 14:53
 * @since: 11
 */
@WebServlet("/user/*")
public class UserController extends BaseController {
    UserService userService = new UserServiceImpl();

    /**
     * 查询用户
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.query()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        String userName = req.getParameter("userName");
        User user = new User(userId, userName);
        String pageStr = req.getParameter("page");
        Integer page = 1;
        if (pageStr != null && !"".equals(pageStr)) {
            page = Integer.valueOf(pageStr);
        }
        String pageSizeStr = req.getParameter("pageSize");
        Integer pageSize = 5;
        if (pageSizeStr != null && !"".equals(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
        // 调用业务层方法
        List<User> userList = userService.queryUser(page, pageSize, user);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (userList != null && userList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("userList", userList);
            int total = userService.queryUserNum(user);
            returnMap.put("pageInfo", new PageInfo(page, pageSize, total));
            entity.setReturnData(returnMap);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("pageInfo", new PageInfo(1, 5, 0));
            entity.setReturnData(returnMap);
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 增加用户
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.add()");
        // 接收请求数据
        String userName = req.getParameter("userName");
        String roleIdStr = req.getParameter("roleId");
        Integer roleId = null;
        if (roleIdStr != null && !"".equals(roleIdStr)) {
            roleId = Integer.valueOf(roleIdStr);
        }
        String isValidStr = req.getParameter("isValid");
        Integer isValid = null;
        if (isValidStr != null && !"".equals(isValidStr)) {
            isValid = Integer.valueOf(isValidStr);
        }
        String regTime = req.getParameter("regTime");
        String headImg = req.getParameter("headImg");
        User user = new User(userName, "1234", roleId, regTime, isValid, headImg, 100);
        // 执行增加
        int rows = userService.addUser(user);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (rows > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_OPERATE.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 根据用户编号查询用户数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.queryByUserId()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        // 查询数据
        User user = userService.queryByUserId(userId);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (user != null) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnData(user);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 修改用户
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.edit()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        String userName = req.getParameter("userName");
        String roleIdStr = req.getParameter("roleId");
        Integer roleId = null;
        if (roleIdStr != null && !"".equals(roleIdStr)) {
            roleId = Integer.valueOf(roleIdStr);
        }
        String isValidStr = req.getParameter("isValid");
        Integer isValid = null;
        if (isValidStr != null && !"".equals(isValidStr)) {
            isValid = Integer.valueOf(isValidStr);
        }
        String regTime = req.getParameter("regTime");
        String headImg = req.getParameter("headImg");
        String versionIdStr = req.getParameter("versionId");
        Integer versionId = null;
        if (versionIdStr != null && !"".equals(versionIdStr)) {
            versionId = Integer.valueOf(versionIdStr);
        }
        User user = new User(userName, "1234", roleId, regTime, isValid, headImg, versionId + 1);
        user.setUserId(userId);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        // 判断当前数据是否是最新数据
        User queryByUidAndVid = userService.queryByUidAndVid(userId, versionId);
        if (queryByUidAndVid != null) {
            int rows = userService.editUser(user);
            if (rows > 0) {
                entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
            } else {
                entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.FAILURED_OPERATE.getReturnMsg());
            }
        } else {
            entity.setReturnCode(CodeAndMsg.DATA_ISUPDATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.DATA_ISUPDATE.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 删除用户
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.delete()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        // 执行删除
        boolean isSuccess = userService.deleteUser(userId);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (isSuccess) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_OPERATE.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 获取所有权限菜单数据和用户默认已有权限菜单编号
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryMenuAndMenuId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.queryMenuAndMenuId()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        // 查询所有的菜单数据
        MenuService menuService = new MenuServiceImpl();
        List<Menu> menuList = menuService.queryAllMenu();
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (menuList != null && menuList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            // 查询原有的权限编号
            UserMenuService userMenuService = new UserMenuServiceImpl();
            List<Integer> menuIdList = userMenuService.queryMenuIdList(userId);
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("menuList", menuList);
            returnMap.put("menuIdList", menuIdList);
            entity.setReturnData(returnMap);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 用户授权
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void grant(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行UserController.grant()");
        // 接收请求数据
        String userIdStr = req.getParameter("userId");
        Integer userId = null;
        if (userIdStr != null && !"".equals(userIdStr)) {
            userId = Integer.valueOf(userIdStr);
        }
        String[] menuIdArrays = req.getParameter("menuIdStrs").split(",");
        List<UserMenu> userMenuList = new ArrayList<>();
        if (menuIdArrays != null && menuIdArrays.length > 0) {
            for (String menuId : menuIdArrays) {
                userMenuList.add(new UserMenu(userId, Integer.valueOf(menuId)));
            }
        }
        boolean isSuccess = userService.grantUserMenu(userId, userMenuList);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (isSuccess) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_OPERATE.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

}
