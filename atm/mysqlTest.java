package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//this class is used to only test the database is working or not
public class mysqlTest {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed. Check the error: " + e.getMessage());
        }
    }
}

