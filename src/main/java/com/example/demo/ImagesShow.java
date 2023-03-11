package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet ("/ImagesShow")
public class ImagesShow extends HttpServlet {
    private static final long serialVersionUTD = 1L;

    public ImagesShow() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doCheck(request, response);
    }

    private void doCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            RequestDispatcher dp = request.getRequestDispatcher("/Login.jsp");
            try {
                dp.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } else {
            for (Cookie c : request.getCookies()) {
                System.out.println(c.getName());
                System.out.println(c.getValue());
            }
            RequestDispatcher dp = request.getRequestDispatcher("/crocodile.jsp");
            try {
                dp.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doCheck(request, response);
    }
}
