package com.darkset;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionFactory {
    private static String user = System.getenv("DB_USER");

    private static String password = System.getenv("DB_PASSWORD");

    public static void main(String[] args) throws SQLException {
//        try(Connection connection = getConnection()){
//            connection.isValid(2);
//            Statement statement = connection.createStatement();
//            ResultSet results = statement.executeQuery("SELECT id, full_name , email , city from customers order by id");
//            while(results.next()){
//                int id = results.getInt(1);
//                String fullName = results.getString("full_name");
//                String email = results.getString(3);
//                String city = results.getString(4);
//                System.out.printf("%d | %s | %s | %s \n" , id , fullName , email , city);
//            }
//        }
//        printExpensiveProducts();
//         List<Product> list = findAllProducts();
//         list.stream().forEach(System.out::println);
//        System.out.println(countCustomers());
        //getFullNameAndCityWithNull();
        numberWithNull();
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db" ,user  , password);
    }

    public static void printExpensiveProducts() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT id , name , price , stock from products where price > 100 order by price desc");
            while(results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                BigDecimal price = results.getBigDecimal("price");
                int stock = results.getInt("stock");
                System.out.printf("%d | %s | %.2f | %d \n", id , name ,price , stock);
            }
        }
    }

    public static List<Product> findAllProducts() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select id, name , price , stock from products");
            List<Product> list = new ArrayList<>();
            while(results.next()){
                Product product = new Product(results.getInt(1) , results.getString(2) , results.getBigDecimal(3) , results.getInt(4));
                list.add(product);
            }
            return list;
        }
    }

    public static long countCustomers() throws SQLException{
        long count = 0;
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select count(*) as total from customers");
            if(results.next()){
                count = results.getLong(1);
            }
        }
        return count;
    }

    public static void getFullNameAndCityWithNull() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select full_name , city from customers");
            while(results.next()){
                String fullName = results.getString(1);
                String city = results.getString(2);
                if(results.wasNull()){
                    System.out.printf("%s | город не указан\n" , fullName);
                }
                else
                    System.out.printf("%s | %s\n" , fullName , city);
            }
        }
    }

    public static void numberWithNull() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select null as missing_number , 0 as actual_zero");
            while(results.next()){
                int field1 = results.getInt(1);
                if(results.wasNull()){
                    System.out.println("field1 is null");
                }
                else
                    System.out.println(field1);
                int field2 = results.getInt(2);
                if(results.wasNull()){
                    System.out.println("field2 is null");
                }
                else
                    System.out.println(field2);
            }
        }
    }

    public static void makeLocalDate() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select full_name, birth_date , registered_at from customers");
            while(results.next()){
                String full_name = results.getString(1);
                LocalDate birth_date = results.getObject(2 , LocalDate.class);
                LocalDate registered_at = results.getObject(3 , LocalDate.class);
                System.out.println(full_name+ " | " + birth_date + " | " + registered_at);
            }
            ResultSetMetaData metaData = results.getMetaData();
            metaData.getColumnCount();
            metaData.getColumnName(1);
            metaData.getColumnClassName(1);
        }
    }







}
