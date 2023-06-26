package com.javasm.service;

import com.javasm.entity.Menu;

import java.util.List;

/**
 * @author:
 * @className: MenuService
 * @description:
 * @date: 2023/6/15 10:06
 * @since: 11
 */
public interface MenuService {
    // 根据用户编号和权限等级查询登录用户的菜单数据
    List<Menu> queryLoginMenuList(Integer userId);

    // 查询所有的菜单数据
    List<Menu> queryAllMenuList(Menu menu,Integer page,Integer pageSize);

    // 查询数据总条数
    Integer queryTotalNum(Menu menu);

    // 查询所有的一级菜单数据
    List<Menu> queryOneMenuList();

    // 根据菜单编号查询菜单数据
    Menu queryMenuByMenuId(Integer menuId);

    // 增加菜单数据
    int addMenu(Menu menu);

    // 修改菜单数据
    int editMenu(Menu menu);

    // 根据菜单编号和版本编号查询菜单数据
    Menu queryByMidAndVid(Integer menuId,Integer versionId);

    // 删除菜单数据
    boolean deleteMenu(Integer menuId);

    // 查询登录用户的二级权限菜单访问地址
    List<String> queryLoginMenuUrl(Integer userId);

    // 查询所有的权限数据
    List<Menu> queryAllMenu();
}
