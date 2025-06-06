package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCFilmCategorySummary extends JDBCParent {

    @Test
    public void printFilmCountByCategory() throws SQLException {
        String sql = """
                SELECT c.name, COUNT(*) AS film_count
                FROM category c
                JOIN film_category fc ON c.category_id = fc.category_id
                GROUP BY c.name
                ORDER BY film_count DESC
                """;

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                int count = rs.getInt("film_count");
                System.out.printf("%s : %d%n", name, count);
            }
        }
    }
}
