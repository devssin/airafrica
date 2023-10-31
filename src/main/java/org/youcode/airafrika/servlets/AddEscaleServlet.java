package org.youcode.airafrika.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.youcode.airafrika.entities.Escale;
import org.youcode.airafrika.services.EscaleService;
import org.youcode.airafrika.services.ServiceImp.EscaleServiceImp;

import java.io.IOException;

@WebServlet(name = "addEscale", value = "/addEscale")
public class AddEscaleServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int vol_id = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("vol_id" , vol_id );
        req.getRequestDispatcher("WEB-INF/Escales/AddEscal.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Escale escale = new Escale();

        escale.setEscale_city(req.getParameter("escale_city"));
        escale.setDuration(Integer.parseInt(req.getParameter("duration")));
        int vol_id = Integer.parseInt(req.getParameter("vol_id"));

        EscaleService escaleService = new EscaleServiceImp();
        escaleService.addEscale(escale, vol_id);

        resp.sendRedirect("vols");


    }
}
