package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 获取http://localhost:8080/menu/query   query
//        System.out.println(req.getServletPath());// /menu    /menu
//        System.out.println(req.getRequestURI());// /menu/query   /menu/add
//        System.out.println(req.getRequestURL());// http://localhost:8080/menu/query
        // 获取query add...
        String methodName = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
//        System.out.println(methodName);
        try {
            // 获取方法对象
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 调用方法执行
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            // e.printStackTrace();
            // 主动返回404，在浏览器呈现
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
