package jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBCPractices01 {

    @Test
    public void test1() throws SQLException {

        // Connection information
        String hostUrl = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://demo.mersys.io:33906/sakila");
        String username = System.getenv().getOrDefault("DB_USER", "admin");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "Techno24Study.%=");

        // Open connection, create statement and execute the query using
        // try-with-resources so that all resources are closed automatically
        try (Connection connection = DriverManager.getConnection(hostUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultTable = statement.executeQuery("select * from actor")) {

            while (resultTable.next()) {
                String name = resultTable.getString("first_name");
                String lastName = resultTable.getString("last_name");
                System.out.printf("Actor: %s %s%n", name, lastName);
            }
        }
    }
}
