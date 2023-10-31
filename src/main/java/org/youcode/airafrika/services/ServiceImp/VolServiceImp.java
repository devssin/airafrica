package org.youcode.airafrika.services.ServiceImp;

import org.youcode.airafrika.dao.PlansDao;
import org.youcode.airafrika.dao.VolDao;
import org.youcode.airafrika.dao.implementation.PlanDaoImp;
import org.youcode.airafrika.dao.implementation.VolDaoImp;
import org.youcode.airafrika.entities.Plan;
import org.youcode.airafrika.entities.Vol;
import org.youcode.airafrika.services.VolService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VolServiceImp implements VolService {
    VolDao volDao = new VolDaoImp();
    PlansDao plansDao = new PlanDaoImp();
    @Override
    public void addVol(Vol vol, int planId) {
        Plan selectedPlan = plansDao.findById(planId);
        vol.setPlan(selectedPlan);
        volDao.create(vol);
    }

    @Override
    public List<Vol> listVols() {
        return volDao.listVols();
    }

    @Override
    public List<Vol> SearchVol(String start_city, String arrive_city, String date) throws ParseException {
        Date start = parseDate(date + "T00:00");
        Date end = parseDate(date + "T23:59");

        return volDao.searchVols(start_city, arrive_city, start, end);
    }

    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return formatter.parse(dateString);
    }


}
