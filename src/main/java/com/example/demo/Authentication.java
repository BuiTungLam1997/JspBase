package com.example.demo;
import com.example.demo.model.DatabaseManagement;
import com.sun.javaws.progress.PreloaderDelegate;
import sun.plugin.com.Dispatcher;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication extends HelloServlet {
    private static final long serialVersionUTD = 1L;

    public Authentication() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        this.loadParameter(request, response, "Authentication by Get");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        this.loadParameter(request, response, "Authentication by Post");
    }

    public void loadParameter(HttpServletRequest request, HttpServletResponse response, String method) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        //  request.getAttribute();
        DatabaseManagement dm = new DatabaseManagement();
        if (dm.checkUser(username, password)) {
            //   response.sendRedirect("show.jsp");
            response.addCookie(new Cookie("location", "VietNam"));

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(15);//thoi gian toi da phien sesion (s)
            session.setAttribute("username", username);

            RequestDispatcher dp = request.getRequestDispatcher("ImagesShow");
            Images images = new Images("Baby", 200, 300);
            request.setAttribute("imagesName", images);
            session.setAttribute("test", new Images("Testting images in", 200, 300));
            session.removeAttribute("test");
            try {
                dp.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

}
