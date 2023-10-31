package org.youcode.airafrika.dao.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.youcode.airafrika.connection.Jpa;
import org.youcode.airafrika.dao.VolDao;
import org.youcode.airafrika.entities.Vol;

import java.util.Date;
import java.util.List;

public class VolDaoImp implements VolDao {

    EntityManager entityManager = Jpa.getInstance().getEntityManager();
    @Override
    public void create(Vol vol) {
       Jpa.beginTransaction();
       entityManager.persist(vol);
       Jpa.commit();
    }

    @Override
    public List<Vol> listVols() {
        return entityManager.createQuery("FROM Vol v" , Vol.class).getResultList();
    }

    @Override
    public List<Vol> searchVols(String start, String arrive, Date date_start, Date date_end) {
        String Hql = "From Vol v where start_city = :start_city and arrive_city = :arrive AND v.starts_at > :start AND v.starts_at <= :end ";
        TypedQuery<Vol> query = entityManager.createQuery(Hql, Vol.class );
        query.setParameter("start_city" , start);
        query.setParameter("arrive" , arrive);
        query.setParameter("start", date_start);
        query.setParameter("end", date_end);

        return query.getResultList();

    }




    @Override
    public Vol findById(int id) {
        return  entityManager.find(Vol.class, id);
    }

    @Override
    public void update(Vol vol) {

        entityManager.merge(vol);


    }

    @Override
    public void delete(int id) {
        Vol vol = entityManager.find(Vol.class, id);
        if(vol != null)
            entityManager.remove(vol);
    }


}
