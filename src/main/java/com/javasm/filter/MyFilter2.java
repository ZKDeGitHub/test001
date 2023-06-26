package com.javasm.filter;

import com.javasm.entity.CodeAndMsg;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.utils.RespUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class MyFilter2 implements Filter {
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
        // 获取请求路径(menu、user等)
        String servletPath = req.getServletPath();
        // 获取用户数据
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        // 判断
        if ("/login".equals(servletPath)) {//白名单
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 不是登录，需要判断是否已登录
            if (loginUser != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                // 写出响应数据
                ReturnEntity entity = new ReturnEntity();
                entity.setReturnCode(CodeAndMsg.NO_LOGIN.getReturnCode());
                entity.setReturnMsg(CodeAndMsg.NO_LOGIN.getReturnMsg());
                RespUtils.handleResp(resp, entity);
            }
        }
    }
}
