package com.javasm.utils;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.ReturnEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author:
 * @className: RespUtils
 * @description: 处理写出响应数据
 * @date: 2023/6/14 17:26
 * @since: 11
 */
public class RespUtils {
    public static void handleResp(HttpServletResponse resp, ReturnEntity entity) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(JSON.toJSONString(entity));
        writer.flush();
        writer.close();
    }



}
