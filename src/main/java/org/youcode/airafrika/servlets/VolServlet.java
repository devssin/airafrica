package org.youcode.airafrika.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.youcode.airafrika.entities.Vol;
import org.youcode.airafrika.services.ServiceImp.VolServiceImp;
import org.youcode.airafrika.services.VolService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Vols", value = "/vols")
public class VolServlet extends HttpServlet {
    VolService volService = new VolServiceImp();
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List <Vol> vols = volService.listVols();
        req.setAttribute("vols", vols);
        req.getRequestDispatcher("WEB-INF/Vols/Vols.jsp").forward(req, resp);
    }
}
