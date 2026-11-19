package com.darkset.AdvanceMappingTypes;

import com.darkset.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TimeZone;

public class PracticeWithAdvancedTypes {
    private final static SessionFactory sessionFactory = new Configuration()
            .setProperty("hibernate.connection.username" , System.getenv("DB_USER"))
            .setProperty("hibernate.connection.password" , System.getenv("DB_PASSWORD")).
            setProperty("hibernate.timezone.default_storage", "COLUMN").
            addAnnotatedClass(CustomerEntity.class).
            buildSessionFactory();

    public static void main(String[] args) throws IOException {
        Session session = sessionFactory.openSession(); //withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC")).
        Transaction transaction = session.beginTransaction();
        CustomerEntity customer = session.find(CustomerEntity.class , 1);
        byte[] photo = Files.readAllBytes(Path.of("C:\\Users\\Sasha\\OneDrive - Dnipro National University\\Рисунки\\Снимок экрана 2026-10-06 195442.png"));
        customer.setPhoto(photo);
        customer.setFullName("VItylik porto");
        transaction.commit();
        session.close();
    }
}
