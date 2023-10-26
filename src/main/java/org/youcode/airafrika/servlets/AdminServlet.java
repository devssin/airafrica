package org.youcode.airafrika.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response){
      try{
          request.getRequestDispatcher("WEB-INF/AdminLogin.jsp").forward(request,response);
      }catch (IOException | ServletException e){
          System.out.println(e.getMessage());
      }
    }

    public void destroy(){}





}
