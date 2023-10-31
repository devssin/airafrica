package org.youcode.airafrika.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.youcode.airafrika.dao.PlansDao;
import org.youcode.airafrika.dao.implementation.PlanDaoImp;
import org.youcode.airafrika.entities.Plan;
import org.youcode.airafrika.entities.Vol;
import org.youcode.airafrika.services.ServiceImp.VolServiceImp;
import org.youcode.airafrika.services.VolService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddVol" , value = "/addVol")
public class AddVolServlet extends HttpServlet {





    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PlansDao plansDao = new PlanDaoImp();
            List<Plan>  plans = plansDao.getAllPlans();
            req.setAttribute("plans" , plans);
            req.getRequestDispatcher("WEB-INF/Vols/AddVol.jsp").forward(req, resp);
        }catch (ServletException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            VolService volService = new VolServiceImp();
            Vol vol = new Vol();
            String start_date_input = req.getParameter("date_starts");
            vol.setStarts_at(parseDate(start_date_input)) ;


            String arrives_date_input = req.getParameter("date_arrives");
            vol.setArrives_at(parseDate(arrives_date_input));
            vol.setStart_city(req.getParameter("start_city"));
            vol.setArrive_city(req.getParameter("arrive_city"));
            vol.setPrice(Double.parseDouble(req.getParameter("price")));
            int plan_id = Integer.parseInt(req.getParameter("plan_id"));

            volService.addVol(vol, plan_id);
            resp.sendRedirect("vols");


        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return formatter.parse(dateString);
    }



}
