package org.youcode.airafrika.dao.implementation;

import jakarta.persistence.EntityManager;
import org.youcode.airafrika.connection.Jpa;
import org.youcode.airafrika.dao.PlansDao;
import org.youcode.airafrika.entities.Plan;

import java.util.List;

public class PlanDaoImp implements PlansDao {
    EntityManager entityManager = Jpa.getInstance().getEntityManager();
    @Override
    public List<Plan> getAllPlans() {
        return entityManager.createQuery("FROM Plan p", Plan.class).getResultList();
    }

    @Override
    public Plan findById(int id) {
        return entityManager.find(Plan.class, id);
    }
}