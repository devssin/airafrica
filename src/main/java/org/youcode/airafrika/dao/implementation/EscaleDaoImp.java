package org.youcode.airafrika.dao.implementation;

import jakarta.persistence.EntityManager;
import org.youcode.airafrika.connection.Jpa;
import org.youcode.airafrika.dao.EscaleDao;
import org.youcode.airafrika.entities.Escale;

public class EscaleDaoImp implements EscaleDao {
    EntityManager entityManager = Jpa.getEntityManager();
    @Override
    public void create(Escale escale) {
        Jpa.beginTransaction();
        entityManager.persist(escale);
        Jpa.commit();

    }
}
