package com.javasm.service.impl;

import com.javasm.entity.User;
import com.javasm.entity.UserMenu;
import com.javasm.mapper.UserMapper;
import com.javasm.mapper.UserMenuMapper;
import com.javasm.service.UserService;
import com.javasm.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author:
 * @className: UserServiceImpl
 * @description:
 * @date: 2023/6/8 16:18
 * @since: 11
 */
public class UserServiceImpl implements UserService {
    @Override
    public User queryByUserNameAndUserPwd(User user) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User loginUser = userMapper.queryByUserNameAndUserPwd(user);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return loginUser;
    }

    @Override
    public List<User> queryUser(Integer page, Integer pageSize, User user) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryUser((page - 1) * pageSize, pageSize, user);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return userList;
    }

    @Override
    public int queryUserNum(User user) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int rows = userMapper.queryUserNum(user);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return rows;
    }

    @Override
    public int addUser(User user) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int rows = userMapper.addUser(user);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return rows;
    }

    @Override
    public User queryByUserId(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryByUserId(userId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User queryByUidAndVid(Integer userId, Integer versionId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryByUidAndVid(userId, versionId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public int editUser(User user) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int rows = userMapper.editUser(user);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return rows;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        boolean isSuccess = false;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionNoCommit();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(userId);
            // 查询用户权限数据
            UserMenuMapper userMenuMapper = sqlSession.getMapper(UserMenuMapper.class);
            List<UserMenu> userMenuList = userMenuMapper.queryUserMenuByUserId(userId);
            if (userMenuList != null && userMenuList.size() > 0) {
                userMenuMapper.deleteUserMenuByUserId(userId);
            }
            // 提交事务
            sqlSession.commit();
            // 设置isSuccess为true
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            // 回退事务
            sqlSession.rollback();
        } finally {
            // 资源关闭
            SqlSessionUtils.closeSqlSession(sqlSession);
        }
        return isSuccess;
    }

    @Override
    public boolean grantUserMenu(Integer userId, List<UserMenu> userMenuList) {
        boolean isSuccess = false;
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionNoCommit();
        UserMenuMapper userMenuMapper = sqlSession.getMapper(UserMenuMapper.class);
        try {
            List<Integer> menuIdList = userMenuMapper.queryMenuIdList(userId);
            if (menuIdList != null && menuIdList.size() > 0) {
                userMenuMapper.deleteUserMenuByUserId(userId);
            }
            if (userMenuList != null && userMenuList.size() > 0) {
                userMenuMapper.addUserMenuBatch(userMenuList);
            }
            sqlSession.commit();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            SqlSessionUtils.closeSqlSession(sqlSession);
        }
        return isSuccess;
    }

    @Override
    public void editLoginTime(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.editLoginTime(userId);
        SqlSessionUtils.closeSqlSession(sqlSession);
    }
}
