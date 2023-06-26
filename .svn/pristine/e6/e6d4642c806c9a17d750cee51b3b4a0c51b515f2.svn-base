package com.javasm.mapper;

import com.javasm.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:
 * @className: MenuMapper
 * @description:
 * @date: 2023/6/15 9:54
 * @since: 11
 */
public interface MenuMapper {
    // 根据用户编号和权限等级查询登录用户的菜单数据
    List<Menu> queryLoginMenuList(@Param("userId") Integer userId, @Param("level") Integer level);

    // 查询所有的菜单数据
    List<Menu> queryAllMenuList(@Param("menu") Menu menu, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

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
    Menu queryByMidAndVid(@Param("menuId") Integer menuId,@Param("versionId") Integer versionId);

    // 删除菜单数据(根据菜单编号)
    int deleteMenuByMenuId(Integer menuId);

    // 根据上级菜单编号查询菜单数据
    List<Menu> queryMenuByParentId(Integer parentId);

    // 删除菜单数据(根据上级菜单编号)
    int deleteMenuByParentId(Integer parentId);

    // 查询登录用户的二级权限菜单访问地址
    List<String> queryLoginMenuUrl(Integer userId);

    // 查询所有的权限数据(按照等级)
    List<Menu> queryAllMenuByLevel(Integer level);


}
