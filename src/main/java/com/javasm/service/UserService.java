package com.javasm.service;


import com.javasm.entity.User;
import com.javasm.entity.UserMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    // 根据用户名和密码查询登录用户数据
    User queryByUserNameAndUserPwd(User user);

    // 查询用户数据(当前页、每页显示的最大条目数、用户编号、用户名称)
    List<User> queryUser(Integer page, Integer pageSize, User user);

    // 查询数据表中数据总条数(用户编号、用户名称)
    int queryUserNum(User user);

    // 增加用户数据
    int addUser(User user);

    // 根据用户编号查询用户数据
    User queryByUserId(Integer userId);

    // 根据用户编号和版本编号查询用户数据
    User queryByUidAndVid(@Param("userId") Integer userId, @Param("versionId") Integer versionId);

    // 修改用户数据
    int editUser(User user);

    // 删除用户数据(用户权限数据)
    boolean deleteUser(Integer userId);

    // 用户权限
    boolean grantUserMenu(Integer userId, List<UserMenu> userMenuList);

    // 修改用户的登录时间
    void editLoginTime(Integer userId);
}
