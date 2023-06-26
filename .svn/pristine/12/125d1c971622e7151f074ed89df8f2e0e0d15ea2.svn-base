package com.javasm.mapper;

import com.javasm.entity.UserMenu;

import java.util.List;

/**
 * @author:
 * @className: UserMenuMapper
 * @description:
 * @date: 2023/6/20 14:55
 * @since: 11
 */
public interface UserMenuMapper {
    // 根据用户编号查询权限数据
    List<UserMenu> queryUserMenuByUserId(Integer userId);

    // 根据用户编号删除用户权限数据
    int deleteUserMenuByUserId(Integer userId);

    // 根据用户编号查询菜单编号
    List<Integer> queryMenuIdList(Integer userId);

    // 批量增加用户权限数据
    int addUserMenuBatch(List<UserMenu> userMenuList);

}
