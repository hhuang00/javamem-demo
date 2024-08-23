package com.example.demo;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 初始构造完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了过滤操作");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤操作完成");
    }

    @Override
    public void destroy() {

    }
}
