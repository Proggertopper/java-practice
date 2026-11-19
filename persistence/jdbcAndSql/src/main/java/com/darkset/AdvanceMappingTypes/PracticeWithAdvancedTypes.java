package com.darkset.AdvanceMappingTypes;

import com.darkset.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.TimeZone;

public class PracticeWithAdvancedTypes {
    private final static SessionFactory sessionFactory = new Configuration()
            .setProperty("hibernate.connection.username" , System.getenv("DB_USER"))
            .setProperty("hibernate.connection.password" , System.getenv("DB_PASSWORD")).
            addAnnotatedClass(CustomerEntity.class).
            buildSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customer = session.find(CustomerEntity.class , 1);
        transaction.commit();
        session.close();
    }
}
