package com.javasm.controller;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.ReturnEntity;
import com.javasm.utils.RespUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取port对象
        Part userHead = req.getPart("userHead");
        //获取文件名称
        String fileName = userHead.getSubmittedFileName();
        //获取服务器真实运行路径 也就是target下的
        String realPath = req.getServletContext().getRealPath("/");
        //定义保存文件的目录
        String foldrName="upload/";
        //在指定位置写入文件
        userHead.write(realPath+foldrName+fileName);
        System.out.println("================="+realPath+foldrName+fileName);
        //给前端返回数据
        ReturnEntity entity=new ReturnEntity();
        entity.setReturnCode(CodeAndMsg.SUCCESS_OPERATE.getReturnCode());
        entity.setReturnMsg(CodeAndMsg.SUCCESS_OPERATE.getReturnMsg());
        entity.setReturnData("http://localhost:8080/"+foldrName+fileName);
        RespUtils.handleResp(resp,entity);

    }
}
