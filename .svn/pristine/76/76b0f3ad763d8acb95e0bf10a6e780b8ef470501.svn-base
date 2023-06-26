package com.javasm.mapper;

import com.javasm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:
 * @className: UserMapper
 * @description:
 * @date: 2023/6/8 16:19
 * @since: 11
 */
public interface UserMapper {
    // 根据用户名和密码查询登录用户数据
    User queryByUserNameAndUserPwd(User user);

    // 查询用户数据(起始索引值、每页显示的最大条目数、用户编号、用户名称)
    List<User> queryUser(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize, @Param("user") User user);

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

    // 删除用户数据
    int deleteUser(Integer userId);

    // 修改用户的登录时间
    void editLoginTime(Integer userId);

}
