package com.javasm.service.impl;

import com.javasm.entity.myEntity.ProductBasic;
import com.javasm.entity.myEntity.ProductCategory;
import com.javasm.entity.myEntity.RemitInfo;
import com.javasm.mapper.CategoryMapper;
import com.javasm.service.CategoryService;
import com.javasm.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public  List<ProductCategory> getCategoryByName
            (Integer page,  Integer pageSize,  String name) {
        SqlSession sqlSessionNoCommit = SqlSessionUtils.getSqlSessionNoCommit();
        CategoryMapper mapper = sqlSessionNoCommit.getMapper(CategoryMapper.class);

        if( ! (name.equals("")||null==name) ){
            name = "%" + name + "%";
        }

        page = (page-1)*pageSize;
        List<ProductCategory> categoryByName = mapper.getCategoryByName(page, pageSize, name);
        SqlSessionUtils.closeSqlSession(sqlSessionNoCommit);
        return categoryByName;
    }

    @Override
    public List<ProductCategory> selectCategoryByEZName(ProductCategory category) {
        SqlSession sqlSessionNoCommit = SqlSessionUtils.getSqlSessionNoCommit();
        CategoryMapper mapper = sqlSessionNoCommit.getMapper(CategoryMapper.class);
        List<ProductCategory> categoryList = mapper.selectCategoryByEZName(category);
        SqlSessionUtils.closeSqlSession(sqlSessionNoCommit);
        return categoryList;
    }

/*    @Override
    public List<ProductCategory> getAllCategory
            (Integer page,  Integer pageSize) {
        SqlSession sqlSessionNoCommit = SqlSessionUtils.getSqlSessionNoCommit();
        CategoryMapper mapper = sqlSessionNoCommit.getMapper(CategoryMapper.class);

        page = (page-1)*pageSize;
        List<ProductCategory> allCategory = mapper.getAllCategory(page, pageSize);
        SqlSessionUtils.closeSqlSession(sqlSessionNoCommit);
        return allCategory;
    }*/

    @Override
    public int getAllNum(String categoryName) {
        SqlSession sqlSessionNoCommit = SqlSessionUtils.getSqlSessionNoCommit();
        CategoryMapper mapper = sqlSessionNoCommit.getMapper(CategoryMapper.class);
        int allNum = mapper.getAllNum(categoryName);
        SqlSessionUtils.closeSqlSession(sqlSessionNoCommit);
        return allNum;
    }

    @Override
    public int updateCetCategory(ProductCategory category) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        return mapper.updateCetCategory(category);
    }

    @Override
    public int insertCetCategory(ProductCategory category) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        return  mapper.insertCetCategory(category);
    }

    @Override
    public int updateCategoryAndRemitInfo(ProductCategory category) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        RemitInfo remitInfo = mapper.getRemitInfoByCategoryId(category.getProductCategoryId());
        int i;
        if(remitInfo==null){
            mapper.insertRemitInfo(category.getRemitInfo());

            i = mapper.updateCetCategoryRemitId(category);
        }else {
            i = mapper.updateRemitInfo(category.getRemitInfo());
        }
        return i;
    }
}
