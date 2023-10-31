package org.youcode.airafrika.services.ServiceImp;

import org.youcode.airafrika.dao.EscaleDao;
import org.youcode.airafrika.dao.PlansDao;
import org.youcode.airafrika.dao.VolDao;
import org.youcode.airafrika.dao.implementation.EscaleDaoImp;
import org.youcode.airafrika.dao.implementation.PlanDaoImp;
import org.youcode.airafrika.dao.implementation.VolDaoImp;
import org.youcode.airafrika.entities.Escale;
import org.youcode.airafrika.entities.Plan;
import org.youcode.airafrika.entities.Vol;
import org.youcode.airafrika.services.EscaleService;

public class EscaleServiceImp implements EscaleService {
    EscaleDao escaleDao = new EscaleDaoImp();
    VolDao volDao = new VolDaoImp();
    @Override
    public void addEscale(Escale escale, int vol_id) {
        PlansDao plansDao = new PlanDaoImp();

        Vol vol = volDao.findById(vol_id);

        escale.setVol(vol);
        escaleDao.create(escale);


    }
}
