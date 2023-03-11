package com.example.demo;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        loadParameter(request, response, "by Get");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        loadParameter(request, response, "by Post");
    }

    public void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        response.setContentType("text/html");
//        String username = request.getParameter("username");
//       String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        // Hello
        ServletContext context = this.getServletContext();//co duy nhat 1 doi tuong context
        String account = context.getInitParameter("account");
        String password = context.getInitParameter("password");
        out.println("account :" + account + "password :" + password);

        ServletConfig config = this.getServletConfig();//config co nhieu ,moi servlet co 1 config khac nhau , moi 1 servlet tao ta co 1 config di kem
        String song = config.getInitParameter("song");
        out.println("this is song :" + song);
//-------------
        out.println("Hello Wolrd " + method + "</br>");

    }

    public void destroy() {
    }
}