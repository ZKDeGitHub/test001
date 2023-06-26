package com.javasm.service.impl;

import com.javasm.entity.Menu;
import com.javasm.listener.DBListener;
import com.javasm.mapper.MenuMapper;
import com.javasm.service.MenuService;
import com.javasm.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @className: MenuServiceImpl
 * @description:
 * @date: 2023/6/15 10:08
 * @since: 11
 */
public class MenuServiceImpl implements MenuService {
    @Override
    public List<Menu> queryLoginMenuList(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        // 一级菜单数据
        List<Menu> menuList = menuMapper.queryLoginMenuList(userId, 1);
        // 二级菜单数据
        List<Menu> subMenuList = menuMapper.queryLoginMenuList(userId, 2);
        // 把对应的二级菜单数据放到一级菜单数据中
        for (Menu menu : menuList) {
            for (Menu subMenu : subMenuList) {
                // 一级菜单编号和二级上级菜单编号
                if (menu.getMenuId().equals(subMenu.getParentId())) {
                    if (menu.getSubMenu() == null) {
                        menu.setSubMenu(new ArrayList<>());
                    }
                    menu.getSubMenu().add(subMenu);
                }
            }
        }
        return menuList;
    }

    @Override
    public List<Menu> queryAllMenuList(Menu menu, Integer page, Integer pageSize) {
        SqlSession sqlSession = DBListener.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<Menu> menuList = menuMapper.queryAllMenuList(menu, (page - 1) * pageSize, pageSize);
        DBListener.closeSqlSession(sqlSession);
        return menuList;
    }

    @Override
    public Integer queryTotalNum(Menu menu) {
        SqlSession sqlSession = DBListener.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        Integer totalNum = menuMapper.queryTotalNum(menu);
        DBListener.closeSqlSession(sqlSession);
        return totalNum;
    }

    @Override
    public List<Menu> queryOneMenuList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<Menu> oneMenuList = menuMapper.queryOneMenuList();
        SqlSessionUtils.closeSqlSession(sqlSession);
        return oneMenuList;
    }

    @Override
    public Menu queryMenuByMenuId(Integer menuId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        Menu menu = menuMapper.queryMenuByMenuId(menuId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return menu;
    }

    @Override
    public int addMenu(Menu menu) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int rows = menuMapper.addMenu(menu);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return rows;
    }

    @Override
    public int editMenu(Menu menu) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int rows = menuMapper.editMenu(menu);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return rows;
    }

    @Override
    public Menu queryByMidAndVid(Integer menuId, Integer versionId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        Menu menu = menuMapper.queryByMidAndVid(menuId, versionId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return menu;
    }

    @Override
    public boolean deleteMenu(Integer menuId) {
        boolean isSuccess = false;

        SqlSession sqlSession = SqlSessionUtils.getSqlSessionNoCommit();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            // 根据菜单编号(假设二级菜单)删除菜单数据
            int rows = menuMapper.deleteMenuByMenuId(menuId);
            // 根据菜单编号(假设一级菜单编号)查询子级菜单数据
            if (menuId <= 1000) {
                List<Menu> subMenuList = menuMapper.queryMenuByParentId(menuId);
                if (subMenuList != null && subMenuList.size() > 0) {
                    int rows2 = menuMapper.deleteMenuByParentId(menuId);
                }
            }
            // 事务提交
            sqlSession.commit();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            sqlSession.rollback();
        } finally {
            // 关闭资源
            SqlSessionUtils.closeSqlSession(sqlSession);
        }
        return isSuccess;
    }

    @Override
    public List<String> queryLoginMenuUrl(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<String> loginMenuUrl = menuMapper.queryLoginMenuUrl(userId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return loginMenuUrl;
    }

    @Override
    public List<Menu> queryAllMenu() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        // 一级菜单数据
        List<Menu> menuList = menuMapper.queryAllMenuByLevel(1);
        // 二级菜单数据
        List<Menu> subMenuList = menuMapper.queryAllMenuByLevel(2);
        // 以一级包含二级的格式
        for (Menu menu : menuList) {
            for (Menu subMenu : subMenuList) {
                if (menu.getMenuId().equals(subMenu.getParentId())) {
                    if (menu.getSubMenu() == null) {
                        menu.setSubMenu(new ArrayList<>());
                    }
                    menu.getSubMenu().add(subMenu);
                }
            }
        }
        return menuList;
    }
}
