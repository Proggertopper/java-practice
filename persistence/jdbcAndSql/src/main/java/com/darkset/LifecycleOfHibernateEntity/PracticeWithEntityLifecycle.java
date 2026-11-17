package com.darkset.LifecycleOfHibernateEntity;

import com.darkset.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PracticeWithEntityLifecycle {
    private final static SessionFactory sessionFactory = new Configuration()
            .setProperty("hibernate.connection.username" , System.getenv("DB_USER"))
            .setProperty("hibernate.connection.password" , System.getenv("DB_PASSWORD")).
            addAnnotatedClass(Category.class).
            buildSessionFactory();

    public static void main(String[] args) {
        try (SessionFactory factory = sessionFactory) {
            Category detached = factory.fromTransaction(session -> {
                Category category = new Category("L11_TEST");
                session.persist(category);
                return category;
            });

            int id = detached.getId();
            detached.setName("L11_MERGED");

            // 1. Сохраняем изменения отсоединённого объекта.
            factory.inTransaction(session -> {
                Category managed = session.merge(detached);
                detached.setName("ONLY_IN_JAVA");

                System.out.println("Один объект? " + (detached == managed));
                System.out.println("detached: " + detached.getName());
                System.out.println("managed: " + managed.getName());
            });

            // 2. Читаем из новой сессии и проверяем refresh().
            factory.inTransaction(session -> {
                Category category = session.find(Category.class, id);
                System.out.println("В базе после merge: " + category.getName());

                category.setName("TEMP");
                session.refresh(category);
                System.out.println("После refresh: " + category.getName());
            });

            // 3. Удаляем именно ту категорию, которую создали.
            factory.inTransaction(session -> {
                Category category = session.find(Category.class, id);
                session.remove(category);
            });

            Category afterDelete = factory.fromTransaction(
                    session -> session.find(Category.class, id)
            );
            System.out.println("После удаления: " + afterDelete);
        }
    }
    }
