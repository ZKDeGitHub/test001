package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.Menu;
import com.javasm.entity.PageInfo;
import com.javasm.entity.ReturnEntity;
import com.javasm.service.MenuService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.utils.CORSUtils;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:
 * @className: MenuController
 * @description: 处理菜单请求
 * @date: 2023/6/15 14:53
 * @since: 11
 */
@WebServlet("/menu/*")
public class MenuController extends BaseController {
    MenuService menuService = new MenuServiceImpl();

    /**
     * 查询菜单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.query()");
        
        // 接收请求数据
        
        // 当前页
        String pageStr = req.getParameter("page");
        Integer page = 1;
        if (pageStr != null && !"".equals(pageStr)) {
            page = Integer.valueOf(pageStr);
        }
        // 每页显示的数据条数
        String pageSizeStr = req.getParameter("pageSize");
        Integer pageSize = 5;
        if (pageSizeStr != null && !"".equals(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
        // 菜单名称
        String menuName = req.getParameter("menuName");
        // 上级菜单编号
        String parentIdStr = req.getParameter("parentId");
        Integer parentId = null;
        if (parentIdStr != null && !"".equals(parentIdStr)) {
            parentId = Integer.valueOf(parentIdStr);
        }
        Menu menu = new Menu(menuName, parentId);
        // 调用业务层方法
        List<Menu> menuList = menuService.queryAllMenuList(menu, page, pageSize);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (menuList != null && menuList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            // 核心数据
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("menuList", menuList);
            Integer total = menuService.queryTotalNum(menu);
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
     * 获取一级菜单数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOneMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Menu> oneMenuList = menuService.queryOneMenuList();
        ReturnEntity entity = new ReturnEntity();
        if (oneMenuList != null && oneMenuList.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnData(oneMenuList);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
        }
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 增加菜单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.add()");
        
        
        // 接收请求数据
        
        // menuId=222&menuName=22&parentId=0&menuUrl=222&glyphicon=Setting
        String menuIdStr = req.getParameter("menuId");
        Integer menuId = null;
        if (menuIdStr != null && !"".equals(menuIdStr)) {
            menuId = Integer.valueOf(menuIdStr);
        }
        String menuName = req.getParameter("menuName");
        String parentIdStr = req.getParameter("parentId");
        Integer parentId = null;
        if (parentIdStr != null && !"".equals(parentIdStr)) {
            parentId = Integer.valueOf(parentIdStr);
        }
        String menuUrl = req.getParameter("menuUrl");
        String glyphicon = req.getParameter("glyphicon");
        Menu menu = new Menu(menuId, menuName, parentId, menuUrl, glyphicon, 100);
        // 执行增加
        Menu menuByMenuId = menuService.queryMenuByMenuId(menuId);
        ReturnEntity entity = new ReturnEntity();
        if (menuByMenuId != null) {
            entity.setReturnCode(CodeAndMsg.DATA_ISUSE.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.DATA_ISUSE.getReturnMsg());
        } else {
            int rows = menuService.addMenu(menu);
            if (rows > 0) {
                entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
            } else {
                entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.FAILURED_OPERATE.getReturnMsg());
            }
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 根据菜单编号查询菜单数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryByMenuId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.queryByMenuId()");
        
        
        // 接收请求数据
        String menuIdStr = req.getParameter("menuId");
        Integer menuId = null;
        if (menuIdStr != null && !"".equals(menuIdStr)) {
            menuId = Integer.valueOf(menuIdStr);
        }
        // 查询菜单数据
        Menu menu = menuService.queryMenuByMenuId(menuId);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (menu != null) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            entity.setReturnData(menu);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
        }
        // 写出响应数据
        RespUtils.handleResp(resp, entity);
    }

    /**
     * 修改菜单数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.edit()");
        
        
        // 接收请求数据
        
        String menuIdStr = req.getParameter("menuId");
        Integer menuId = null;
        if (menuIdStr != null && !"".equals(menuIdStr)) {
            menuId = Integer.valueOf(menuIdStr);
        }
        String menuName = req.getParameter("menuName");
        String parentIdStr = req.getParameter("parentId");
        Integer parentId = null;
        if (parentIdStr != null && !"".equals(parentIdStr)) {
            parentId = Integer.valueOf(parentIdStr);
        }
        String menuUrl = req.getParameter("menuUrl");
        String glyphicon = req.getParameter("glyphicon");
        String versionIdStr = req.getParameter("versionId");
        Integer versionId = null;
        if (versionIdStr != null && !"".equals(versionIdStr)) {
            versionId = Integer.valueOf(versionIdStr);
        }
        // 设置响应数据
        // 查询当前数据是否最新数据
        Menu queryByMidAndVid = menuService.queryByMidAndVid(menuId, versionId);
        ReturnEntity entity = new ReturnEntity();
        if (queryByMidAndVid != null) {
            // 执行修改
            Menu menu = new Menu(menuId, menuName, parentId, menuUrl, glyphicon, versionId + 1);
            int rows = menuService.editMenu(menu);
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
     * 删除菜单数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行MenuController.delete()");
        
        
        // 接收请求数据
        String menuIdStr = req.getParameter("menuId");
        Integer menuId = null;
        if (menuIdStr != null && !"".equals(menuIdStr)) {
            menuId = Integer.valueOf(menuIdStr);
        }
        // 执行删除
        boolean isSuccess = menuService.deleteMenu(menuId);
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
