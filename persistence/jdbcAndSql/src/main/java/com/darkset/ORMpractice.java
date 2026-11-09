package com.darkset;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class ORMpractice {
    public static void main(String[] args) throws IOException {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//
//        Properties properties = new Properties();
//        properties.load(classLoader.getResourceAsStream("hibernate-dev.properties"));
//        SessionFactory sessionFactory = new Configuration()
//                .addProperties(properties)
//                .buildSessionFactory();
        try(SessionFactory sessionFactory = new Configuration()
                .setProperty("hibernate.connection.username" , System.getenv("DB_USER"))
                .setProperty("hibernate.connection.password" , System.getenv("DB_PASSWORD"))
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();Session session1 = sessionFactory.openSession(); Session session2 = sessionFactory.openSession();
            Session session3 = sessionFactory.openSession()){

            Transaction transaction1 = session1.beginTransaction();
            Category category = new Category("HIB_9_TEST");
            session1.persist(category);
            transaction1.commit();
            int id = category.getId();

            Transaction transaction2 = session2.beginTransaction();
            Category findCategoryById =  session2.find(Category.class ,id);
            findCategoryById.setName("HIB_L9_RENAMED");
            transaction2.commit();
            System.out.println(findCategoryById.getName());

            Category detached;

            try(Session session = sessionFactory.openSession()){
                detached = session.find(Category.class , id);
            }

            detached.setName("ONLY_IN_JAVA");
            System.out.println("В старом объекте: " + detached.getName());

            try (Session session = sessionFactory.openSession()) {
                Category reloaded = session.find(Category.class, id);
                System.out.println("В базе: " + reloaded.getName());
            }

            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();

                try {
                    Category categoryToChange = session.find(Category.class, id);
                    categoryToChange.setName("WILL_BE_ROLLED_BACK");

                    session.flush(); // Hibernate отправляет UPDATE в MySQL.
                } finally {
                    transaction.rollback(); // MySQL отменяет UPDATE.
                }
            }

            try (Session session = sessionFactory.openSession()) {
                Category reloaded = session.find(Category.class, id);
                System.out.println("После rollback: " + reloaded.getName());
            }

            Transaction transaction3 = session3.beginTransaction();
            Category findCategoryByIdAndRemove =  session3.find(Category.class ,id);
            session3.remove(findCategoryByIdAndRemove);
            transaction3.commit();

            try (Session session = sessionFactory.openSession()) {
                Category deleted = session.find(Category.class, id);
                System.out.println("После удаления: " + deleted);
            }



        }

    }
}
