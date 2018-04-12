package com.abra.university.databases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class HibernateUtil {

  private static final String PERSISTENT_UNIT_NAME = "universitydb";

//  private static final EntityManagerFactory emf;
//
//  static {
//    try {
//      emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
//    } catch (Throwable ex) {
//      throw new ExceptionInInitializerError(ex);
//    }
//  }
//
//  public static EntityManager getEm() {
//    return emf.createEntityManager();
//  }

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    ExampleEntity exampleEntity = ExampleEntity.builder().name("namich").build();

    session.persist(exampleEntity);

    session.getTransaction().commit();
    session.close();
    System.out.println("HibernateUtil.main");
    sessionFactory.close();
  }
}
