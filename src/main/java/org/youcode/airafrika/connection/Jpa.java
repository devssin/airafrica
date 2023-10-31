package org.youcode.airafrika.connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

import java.util.HashMap;

public class Jpa {

    private static Jpa instance = null;
    private final EntityManagerFactory entityManagerFactory;
    @Getter
    private static  EntityManager entityManager = null;

    private Jpa() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static Jpa getInstance() {
        if (instance == null) {
            instance = new Jpa();
        }
        return instance;
    }
    public static void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }

    }


    public static void commit(){
        entityManager.getTransaction().commit();
    }

    public static void rollback(){
        entityManager.getTransaction().rollback();
    }

}
