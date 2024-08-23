package com.example.demo.Servlet;

import org.apache.catalina.Context;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationFilterConfig;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.security.SecurityUtil;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

@WebServlet("/kill")
public class KillShell extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filter_Name = request.getParameter("name");
        Field Configs = null;
        Map filterConfigs;
        try {
            //反序列化执行代码反射获取到StandardContext
            //这里是反射获取ApplicationContext的context，也就是standardContext
            ServletContext servletContext = request.getSession().getServletContext();

            Field appctx = servletContext.getClass().getDeclaredField("context");
            appctx.setAccessible(true);
            ApplicationContext applicationContext = (ApplicationContext) appctx.get(servletContext);

            Field stdctx = applicationContext.getClass().getDeclaredField("context");
            stdctx.setAccessible(true);
            StandardContext standardContext = (StandardContext) stdctx.get(applicationContext);
            //

            String FilterName = filter_Name;
            Configs = standardContext.getClass().getDeclaredField("filterConfigs");
            Configs.setAccessible(true);
            filterConfigs = (Map) Configs.get(standardContext);

            Map<String, ApplicationFilterConfig> filterConfigMap = (Map<String, ApplicationFilterConfig>)filterConfigs;

            for(Map.Entry<String, ApplicationFilterConfig> map : filterConfigMap.entrySet()){
                String filterName = map.getKey();
                ApplicationFilterConfig filterConfig = map.getValue();
                // 反射获取 getFilter() 方法。反射可以让你绕过访问控制来调用私有方法。
                Method getFilterMethod = ApplicationFilterConfig.class.getDeclaredMethod("getFilter");
                // 设置方法可访问
                getFilterMethod.setAccessible(true);
                // 调用 getFilter() 方法
                Object filterObject = getFilterMethod.invoke(filterConfig);
                //Filter filterObject = filterConfig.getFilter();
                // 如果是内存马的filter名
                if(filterName.startsWith(FilterName)){
                    SecurityUtil.remove(filterObject);
                    filterConfigMap.remove(filterName);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }



}
