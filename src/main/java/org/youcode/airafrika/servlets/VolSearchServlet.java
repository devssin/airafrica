package org.youcode.airafrika.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.youcode.airafrika.entities.Vol;
import org.youcode.airafrika.services.ServiceImp.VolServiceImp;
import org.youcode.airafrika.services.VolService;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "Search" , value = "/searchVols")
public class VolSearchServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/VolsSearch.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VolService volService = new VolServiceImp();
        String city_start = req.getParameter("start_city");
        String city_arrive = req.getParameter("arrive_city");
        String date = req.getParameter("start_date");
        System.out.println(date);
        System.out.println(city_start);
        System.out.println(city_arrive);

        try {
            List<Vol> vols = volService.SearchVol(city_start, city_arrive, date);
            req.setAttribute("vols", vols);
            req.getRequestDispatcher("WEB-INF/Client/Vols.jsp").forward(req,resp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
