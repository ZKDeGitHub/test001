package com.javasm.controller.myController;

import com.javasm.controller.BaseController;
import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.PageInfo;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.entity.myEntity.ProductCategory;
import com.javasm.entity.myEntity.RemitInfo;
import com.javasm.service.CategoryService;
import com.javasm.service.impl.CategoryServiceImpl;
import com.javasm.utils.RespUtils;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/Category/*")
public class CategoryController extends BaseController {

    CategoryService categoryService = new CategoryServiceImpl();


    public void getCategoryByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收请求数据
        String categoryName = req.getParameter("productCategoryZNname");

        String pageStr = req.getParameter("page");

        Integer page = 1;
        if (pageStr != null && !"".equals(pageStr)) {
            page = Integer.valueOf(pageStr);
        }
        String pageSizeStr = req.getParameter("pageSize");
        Integer pageSize = 5;
        if (pageSizeStr != null && !"".equals(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }

        List<ProductCategory> categoryByName = categoryService.getCategoryByName(page,pageSize,categoryName);
        // 设置响应数据
        ReturnEntity entity = new ReturnEntity();
        if (categoryByName != null && categoryByName.size() > 0) {
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("userList", categoryByName);
            int total = categoryService.getAllNum(categoryName);
            returnMap.put("pageInfo", new PageInfo(page, pageSize, total));
            entity.setReturnData(returnMap);
        } else {
            entity.setReturnCode(CodeAndMsg.FAILURED_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.FAILURED_QUERY.getReturnMsg());
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("pageInfo", new PageInfo(1, 5, 0));
            entity.setReturnData(returnMap);
        }
        // 写出响应数据
            RespUtils.handleResp(resp, entity);
    }
    public void insertCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收请求数据
        String productCategoryZNname = req.getParameter("productCategoryZNname");
        String productCategoryType = req.getParameter("productCategoryType");
        String productCategoryPipeline = req.getParameter("productCategoryPipeline");
        String productCategoryENname = req.getParameter("productCategoryENname");

        ProductCategory category = new ProductCategory();
        category.setProductCategoryENname(productCategoryENname);
        category.setProductCategoryPipeline(productCategoryPipeline);
        category.setProductCategoryType(productCategoryType);
        category.setProductCategoryZNname(productCategoryZNname);

        List<ProductCategory> categoryList = categoryService.selectCategoryByEZName(category);
        ReturnEntity entity = new ReturnEntity();
        if(categoryList.size() == 0){
            int i = categoryService.insertCetCategory(category);
            if(i==1){
                entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
            }else {
                entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
                entity.setReturnMsg("添加失败！！！");
            }
        }else {
            entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
            entity.setReturnMsg("名称重复！！！");
        }
        RespUtils.handleResp(resp,entity);
    }
    public void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收请求数据
        String productCategoryId = req.getParameter("productCategoryId");
        String productCategoryZNname = req.getParameter("productCategoryZNname");
        String productCategoryType = req.getParameter("productCategoryType");
        String productCategoryPipeline = req.getParameter("productCategoryPipeline");
        String productCategoryENname = req.getParameter("productCategoryENname");

        ProductCategory category = new ProductCategory();
        category.setProductCategoryId(Long.parseLong(productCategoryId));
        category.setProductCategoryENname(productCategoryENname);
        category.setProductCategoryPipeline(productCategoryPipeline);
        category.setProductCategoryType(productCategoryType);
        category.setProductCategoryZNname(productCategoryZNname);

        int categoryList = categoryService.updateCetCategory(category);
        ReturnEntity entity = new ReturnEntity();
        if(categoryList == 1){
                entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
        }else {
                entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
                entity.setReturnMsg("更新失败！！！");
            }

        RespUtils.handleResp(resp,entity);
    }

    public void updateCategoryAndRemitInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收请求数据
        String productCategoryId = req.getParameter("productCategoryId");
        String remitId = req.getParameter("remitId");
        String bankName = req.getParameter("bankName");
        String bankCode = req.getParameter("bankCode");
        String swiftCode = req.getParameter("swiftCode");
        String cnapsCode = req.getParameter("cnapsCode");
        String bankArea = req.getParameter("bankArea");
        String bankCity = req.getParameter("bankCity");
        String payeeName = req.getParameter("payeeName");
        String payeeAccountCode = req.getParameter("payeeAccountCode");
        String payeeAddress = req.getParameter("payeeAddress");
        String assetManagement = req.getParameter("assetManagement");


        ProductCategory category = new ProductCategory();
        category.setProductCategoryId(Long.parseLong(productCategoryId));
        category.setRemitId(Long.parseLong(remitId));
        RemitInfo remitInfo = new RemitInfo();
        remitInfo.setRemitId(Long.parseLong(remitId));
        remitInfo.setBankName(bankName);
        remitInfo.setBankCode(bankCode);
        remitInfo.setSwiftCode(swiftCode);
        remitInfo.setCnapsCode(cnapsCode);
        remitInfo.setBankArea(bankArea);
        remitInfo.setBankCity(bankCity);
        remitInfo.setPayeeName(payeeName);
        remitInfo.setPayeeAccountCode(payeeAccountCode);
        remitInfo.setPayeeAddress(payeeAddress);
        remitInfo.setAssetManagement(assetManagement);
        remitInfo.setProductCategoryId(Long.parseLong(productCategoryId));
        category.setRemitInfo(remitInfo);


        int info = categoryService.updateCategoryAndRemitInfo(category);
        ReturnEntity entity = new ReturnEntity();
        if(info == 1){
            entity.setReturnCode(CodeAndMsg.SUCCESS_QUERY.getReturnCode());
            entity.setReturnMsg(CodeAndMsg.SUCCESS_QUERY.getReturnMsg());
        }else {
            entity.setReturnCode(CodeAndMsg.FAILURED_OPERATE.getReturnCode());
            entity.setReturnMsg("更新失败！！！");
        }

        RespUtils.handleResp(resp,entity);
    }

}
