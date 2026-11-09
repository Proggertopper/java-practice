package com.darkset;

import java.sql.*;
import java.util.Optional;

public class PreparedStatementPractice {

    private static String user = System.getenv("DB_USER");

    private static String password = System.getenv("DB_PASSWORD");

    public static void main(String[] args) throws SQLException {
        findCustomerByEmail("bereza@gmail.com").ifPresentOrElse(customer -> System.out.println(customer.fullName()) , () -> System.out.println("нет такого клиента"));
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db" ,user  , password);
    }

    public static Optional<Customer> findCustomerByEmail(String email) throws SQLException{
        Customer customer;
        Connection connection = getConnection();
        try(PreparedStatement statement = connection.prepareStatement("select id, full_name , email ,city from customers where email = ?")){
            statement.setString(1 , email);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            customer = new Customer(resultSet.getInt(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4));
        }

        try {
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            int rowsCount1 = statement.executeUpdate("update products set price = price + 10");
            int rowsCount2 = statement.executeUpdate("update products set price = price + 20");
            Savepoint savepoint = connection.setSavepoint();
            try {
                int rowsCount3 = statement.executeUpdate("update productss set price = price + 30");
            } catch (Exception e){
                connection.rollback(savepoint);
            }

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO jc_contact (first_name, last_name, phone, email) VALUES (?, ?, ?, ?)");

        for (int i = 0; i < 10; i++) {
            // Заполняем параметры запроса
            stmt.setString(1, "FirstName_" + i);
            stmt.setString(2, "LastNAme_" + i);
            stmt.setString(3, "phone_" + i);
            stmt.setString(4, "email_" + i);

            stmt.addBatch();
        }
// Выполняем все запросы разом
        int[] results = stmt.executeBatch();

        return customer.email().isEmpty() ? Optional.empty() : Optional.of(customer);
    }


}
