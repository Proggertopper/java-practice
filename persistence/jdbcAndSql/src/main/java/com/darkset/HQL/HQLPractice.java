package com.darkset.HQL;

import com.darkset.Category;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPractice {

    private static final SessionFactory sessionFactory = new Configuration()
            .setProperty("hibernate.connection.username" , System.getenv("DB_USER"))
            .setProperty("hibernate.connection.password" , System.getenv("DB_PASSWORD"))
            .addAnnotatedClass(Category.class)
            .buildSessionFactory();


    public static void main(String[] args){
//            Session session = sessionFactory.openSession();
//            List<Category> categories = session.createQuery("from Category order by id desc" , Category.class).getResultList();
//            categories.forEach(category -> {
//                System.out.println(category.getId() + " " + category.getName());
//            });
//        findByNameContaining("Comp%");
//        count();
        printOnly2PagesCategories();
    }

    public static void findByNameContaining(String text){
        Session session = sessionFactory.openSession();
        List<Category> categoriesThatMatchPattern = session.createQuery("from Category where name like :pattern" , Category.class).setParameter("pattern", text).getResultList();
        if(categoriesThatMatchPattern.isEmpty()){
            System.out.println("categories with that name containing is missed");
        }
        categoriesThatMatchPattern.forEach(category -> {
            System.out.println(category.getId() + " " + category.getName());
        });
    }

    public static void count(){
        Session session = sessionFactory.openSession();
        Long countOfCategories = session.createQuery("select count(name) from Category" , Long.class).getSingleResult();
        System.out.println(countOfCategories);
    }

    public static void printOnly2PagesCategoriesAndOtherPractices(){
        Session session = sessionFactory.openSession();
        Query<Category> query = session.createQuery("from Category" , Category.class);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List<Category> categories = query.list();
        categories.forEach(System.out::println);
        NativeQuery<Category> categoryNativeQuery = session.createNativeQuery("select * from categories" , Category.class);
        Query<Category> query2 = session.createNamedQuery("Category_FindByID" , Category.class).setParameter("id" , 1);
        query2.list().forEach(System.out::println);

        Query<Category> query3 = session.createQuery("from Category where id > 1", Category.class);
        ScrollableResults<Category> scrollableResults = query3.scroll();
        scrollableResults.last();
        Category category = scrollableResults.get();
        scrollableResults.close();
        session.close();

    }
}
