package org.youcode.airafrika.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.youcode.airafrika.services.AdminService;
import org.youcode.airafrika.services.ServiceImp.AdminImp;

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService adminService = new AdminImp();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error = "";
        if(username.isEmpty() || password.isEmpty()){
            error = "You must fill all fields";
        }else if (!adminService.authenticate(username, password)){
            error = "Invalid username or password ";

        }

        if(!error.isEmpty()){
            request.setAttribute("message" , error);
            request.getRequestDispatcher("WEB-INF/AdminLogin.jsp").forward(request, response);
        }else {
            HttpSession seasson = request.getSession();
            seasson.setAttribute("username" , username);
            response.sendRedirect("vols");
        }
    }


    public void destroy(){}





}
