package com.javasm.service.impl;
import com.javasm.mapper.UserMenuMapper;
import com.javasm.service.UserMenuService;
import com.javasm.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class UserMenuServiceImpl implements UserMenuService {


    @Override
    public List<Integer> queryMenuIdList(Integer userId) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMenuMapper userMenuMapper = sqlSession.getMapper(UserMenuMapper.class);
        List<Integer> userMenuIdList = userMenuMapper.queryMenuIdList(userId);
        SqlSessionUtils.closeSqlSession(sqlSession);
        return userMenuIdList;
    }
}
