package jdbc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSakilaCustomerAddAndVerifyExample extends JDBCParent {
    /**
         With JDBC on the Sakila database:
         1) Add a new customer
         2) Print the last 10 customers (ordered by customer_id)
         3) Find the added customer by email and verify with assertions
     */

    @Test
    public void addCustomerAndVerify() {
        String expectedFirstName = "Atilla";
        String expectedMail = "atilla@demomail.com";
        String actualFirstName = null;
        String actualMail = null;

        // 1) Add a new customer
        try {
            System.out.println("\n1) Adding a New Customer:");
            String lastName = "Erdem";
            int addressId = 44;
            int active = 1;

            String insertCustomerQuery = "INSERT INTO customer (store_id, first_name, last_name, email, address_id, active) " +
                    "VALUES (1, '" + expectedFirstName + "', '" + lastName + "', '" + expectedMail + "', " + addressId + ", " + active + ")";

            statement = connection.createStatement();
            statement.executeUpdate(insertCustomerQuery);
            System.out.println("New customer added: " + expectedFirstName + " " + lastName + " (" + expectedMail + ")");

            // 2) Print the last 10 customers
            System.out.println("\n2) Last 10 Added Customers:");
            String customerListQuery = "SELECT customer_id, first_name, last_name, email FROM customer ORDER BY customer_id DESC LIMIT 10";

            try (ResultSet customerRs = statement.executeQuery(customerListQuery)) {
                while (customerRs.next()) {
                    System.out.println("Customer ID: " + customerRs.getInt("customer_id")
                            + ", First Name: " + customerRs.getString("first_name")
                            + ", Last Name: " + customerRs.getString("last_name")
                            + ", Email: " + customerRs.getString("email"));
                }
            }

            // 3) Find and verify the added customer by email
            System.out.println("\n3) Verifying the Added Customer:");
            String verifyCustomerQuery = "SELECT first_name, email FROM customer WHERE email = '" + expectedMail + "'";

            try (ResultSet verifyRs = statement.executeQuery(verifyCustomerQuery)) {
                if (verifyRs.next()) {
                    actualFirstName = verifyRs.getString("first_name");
                    actualMail = verifyRs.getString("email");
                    System.out.println("Verified Customer - First Name: " + actualFirstName + ", Email: " + actualMail);
                } else {
                    System.out.println("New customer not found!");
                }
            }

            Assert.assertEquals(actualFirstName, expectedFirstName, "The added customer's first name is incorrect!");
            Assert.assertEquals(actualMail, expectedMail, "The added customer's email is incorrect!");

            System.out.println("\n--- ALL OPERATIONS COMPLETED SUCCESSFULLY ---\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
