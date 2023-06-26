package com.javasm.filter;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.ReturnEntity;
import com.javasm.utils.RespUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebFilter("/*")
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 接收请求路径
        String servletPath = req.getServletPath();
        // 获取权限地址
        HttpSession session = req.getSession();
        List<String> loginMenuUrl = (List<String>) session.getAttribute("loginMenuUrl");
        // 判断
        if ("/login".equals(servletPath)
                || "/main".equals(servletPath)
                || "/logout".equals(servletPath)
                || "/upload".equals(servletPath)
        || servletPath.endsWith(".jpg")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 判断有无权限
            if (loginMenuUrl.contains(servletPath)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ReturnEntity entity = new ReturnEntity();
                entity.setReturnCode(CodeAndMsg.NO_AUTH.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.NO_AUTH.getReturnMsg());
                RespUtils.handleResp(resp, entity);
            }
        }
    }

}
