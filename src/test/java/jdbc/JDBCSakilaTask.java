package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBCSakilaTask extends JDBCParent {

    /**
     * Demonstrates basic JDBC operations on the Sakila database. The test
     * performs the following steps:
     * <ol>
     *   <li>Connect to the database (handled by {@link JDBCParent})</li>
     *   <li>Retrieve and print a list of films</li>
     *   <li>Insert a new customer</li>
     *   <li>Query the newly inserted customer</li>
     *   <li>Close the connection</li>
     * </ol>
     */
    @Test
    public void test1() {
        try {
            // Create and execute an SQL statement (Film List)
            try (Statement statement = connection.createStatement()) {

                // Retrieve and print the film list
                String filmSql = "SELECT film_id, title, release_year FROM film";
                try (ResultSet rs = statement.executeQuery(filmSql)) {
                    System.out.println("\u001B[32m" + "Film List:" + "\u001B[0m");
                    while (rs.next()) {
                        int id = rs.getInt("film_id");
                        String title = rs.getString("title");
                        int releaseYear = rs.getInt("release_year");
                        System.out.println("Film ID: " + id + ", Title: " + title + ", Release Year: " + releaseYear);
                    }
                }

                // Set a default value for the create_date column
                String sqlAlterTable = "ALTER TABLE customer MODIFY COLUMN create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP";
                statement.executeUpdate(sqlAlterTable);

                // Insert a new customer
                String firstName = "Hakan";
                String lastName = "Kaan";
                String email = "oguzhan@techno.com";
                int addressId = 44;
                int active = 1;

                String customerInsertSql = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active) VALUES (?,?,?,?,?,?)";
                try (PreparedStatement ps = connection.prepareStatement(customerInsertSql)) {
                    ps.setInt(1, 1);
                    ps.setString(2, firstName);
                    ps.setString(3, lastName);
                    ps.setString(4, email);
                    ps.setInt(5, addressId);
                    ps.setInt(6, active);
                    ps.executeUpdate();
                }
                System.out.println("\u001B[31m" + "\nNew customer added." + "\u001B[0m");

                // Query the newly inserted customer
                String newCustomerSql = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 1";
                try (ResultSet newCustomerRs = statement.executeQuery(newCustomerSql)) {
                    System.out.println("\u001B[33m" + "\nNew Customer Information:" + "\u001B[0m");
                    if (newCustomerRs.next()) {
                        int id = newCustomerRs.getInt("customer_id");
                        String newFirstName = newCustomerRs.getString("first_name");
                        String newLastName = newCustomerRs.getString("last_name");
                        String newEmail = newCustomerRs.getString("email");
                        int newAddressId = newCustomerRs.getInt("address_id");
                        int newActive = newCustomerRs.getInt("active");
                        System.out.println("\nCustomer ID: " + id + ", First Name: " + newFirstName + ", Last Name: " + newLastName + ", Email: " + newEmail + ", Address ID: " + newAddressId + ", Active: " + newActive);
                    }
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        System.out.println("\u001B[32m" + "\nProcess completed." + "\u001B[0m");
    }
}
