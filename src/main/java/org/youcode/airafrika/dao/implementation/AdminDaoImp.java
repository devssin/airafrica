package org.youcode.airafrika.dao.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.youcode.airafrika.connection.Jpa;
import org.youcode.airafrika.dao.AdminDao;
import org.youcode.airafrika.entities.Admin;

public class AdminDaoImp implements AdminDao {

    EntityManager entityManager = Jpa.getInstance().getEntityManager();

    @Override
    public Admin findAdminByUsername(String username) {
        Admin admin = null;
        try {
            String Hql = "FROM Admin a WHERE a.username = :username";
            TypedQuery<Admin> query = entityManager.createQuery(Hql, Admin.class);
            query.setParameter("username", username);
            admin = query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return admin;
    }
}
