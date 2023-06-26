package com.javasm.mapper;

import com.javasm.entity.myEntity.ProductBasic;
import com.javasm.entity.myEntity.ProductCategory;
import com.javasm.entity.myEntity.RemitInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<ProductCategory> getCategoryByName (@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("name") String name);

    List<ProductCategory> selectCategoryByEZName(@Param("category") ProductCategory category);

    int getAllNum(@Param("name") String categoryName);

    int updateCetCategory(@Param("category") ProductCategory category);

    int insertCetCategory(@Param("category") ProductCategory category);

    int updateRemitInfo(@Param("remitInfo") RemitInfo remitInfo);

    RemitInfo getRemitInfoByCategoryId(@Param("categoryId") Long categoryId);

    int insertRemitInfo(@Param("remitInfo") RemitInfo remitInfo);

    int updateCetCategoryRemitId(@Param("category") ProductCategory category);

}
