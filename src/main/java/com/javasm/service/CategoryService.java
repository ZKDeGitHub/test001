package com.javasm.service;

import com.javasm.entity.myEntity.ProductBasic;
import com.javasm.entity.myEntity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> getCategoryByName(Integer page,Integer pageSize,String name);

    List<ProductCategory> selectCategoryByEZName( ProductCategory category);

    int getAllNum(String categoryName);

    int updateCetCategory(ProductCategory category);

    int insertCetCategory(ProductCategory category);

    int updateCategoryAndRemitInfo(ProductCategory category);



}
