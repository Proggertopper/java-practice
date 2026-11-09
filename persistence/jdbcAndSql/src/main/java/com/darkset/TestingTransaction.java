package com.darkset;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;

public class TestingTransaction {
    private final static HikariConfig hikariConfig = new HikariConfig();
    private final static HikariDataSource ds;

    private static String user = System.getenv("DB_USER");

    private static String password = System.getenv("DB_PASSWORD");

    static {
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/shop_db");
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        hikariConfig.setMaximumPoolSize(1);
        hikariConfig.setConnectionTimeout(2000);

        ds = new HikariDataSource(hikariConfig);
    }

    public static Connection getConnectionFromHikariCP() throws SQLException {
        return ds.getConnection();
    }


    public static void main(String[] args) throws SQLException, IOException {
//            testTransactions(1 , 2 , new BigDecimal(1100) , new BigDecimal(1200));
//        getCachedResultSet();

            try (Connection first = getConnectionFromHikariCP()) {
                System.out.println("Первое соединение занято");
            }
            try (Connection next = getConnectionFromHikariCP()) {
                System.out.println("После возврата соединение снова доступно: ");
            }

        Path original = Path.of("sample.txt");
        Path copy = Path.of("sample-copy.txt");

        int id = saveFile(original);
        loadFile(id, copy);

        System.out.println(Files.mismatch(original, copy) == -1);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db", user , password );
    }

    public static void testTransactions(int id1, int id2, BigDecimal price1, BigDecimal price2) throws SQLException {
        String sql = "UPDATE products SET price = ? WHERE id = ?";

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            try {
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setBigDecimal(1, price1);
                    statement.setInt(2, id1);
                    if(statement.executeUpdate() != 1){
                        throw new SQLException("Не обновился товар " + id1);
                    }

                    statement.setBigDecimal(1, price2);
                    statement.setInt(2, id2);
                    if (statement.executeUpdate() != 1) {
                        throw new SQLException("Не обновился товар " + id2);
                    }
                }

                connection.commit();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackError) {
                    e.addSuppressed(rollbackError);
                }
                throw e;
            }
        }
    }

    public static BigDecimal getCustomerTotalSpent(int customerId) throws SQLException{
        try(Connection connection = getConnection()){
            CallableStatement callableStatement = connection.prepareCall("{call get_customer_total_spent(? , ?)}");

            callableStatement.setInt(1 , customerId);
            callableStatement.registerOutParameter(2 , Types.DECIMAL);
            callableStatement.execute();

            return callableStatement.getBigDecimal(2);
        }
    }

    public static void getScrollingResultSet() throws SQLException{
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
            ResultSet results = statement.executeQuery("SELECT id, name, price FROM products ORDER BY id");
            while (results.next()){
                System.out.println(results.last());
                System.out.println(results.first());
            }
        }
    }

    public static void getCachedResultSet() throws SQLException {
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT id, name, price FROM products ORDER BY id");

            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(results);

            connection.close();		// Закрываем соединение

            while(crs.next()) {
                System.out.println(crs.getString(1)+"\t"+ crs.getString(2)+"\t"+ crs.getString(3));
            }
        }

    }

    public static int saveFile(Path path) throws IOException, SQLException {
        byte[] bytes = Files.readAllBytes(path);

        String sql = "INSERT INTO jdbc_files (file_name, content) VALUES (?, ?)";

        try (Connection connection = getConnectionFromHikariCP();
             PreparedStatement stmt = connection.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, path.getFileName().toString());
            stmt.setBytes(2, bytes);
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (!keys.next()) {
                    throw new SQLException("MySQL не вернул ID файла");
                }
                return keys.getInt(1);
            }
        }
    }

    public static void loadFile(int id, Path target)
            throws IOException, SQLException {

        String sql = "SELECT content FROM jdbc_files WHERE id = ?";

        try (Connection connection = getConnectionFromHikariCP();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new SQLException("Файл не найден: " + id);
                }

                byte[] bytes = rs.getBytes("content");
                Files.write(target , bytes , StandardOpenOption.CREATE_NEW);
            }
        }
    }
//
//    public static void createJdbcRowSetConnection() throws SQLException {
//        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
//        rowSet.setUrl();
//        rowSet.setUsername();
//        rowSet.setCommand();
//        rowSet.execute();
//    }
}
