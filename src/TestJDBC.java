/**
 * Created by tage on 15-8-13.
 */

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection coon = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //new com.mysql.jdbc.Driver();

            String url = "jdbc:mysql://localhost:3306/testJDBC";
            coon = DriverManager.getConnection(url, "root", "root");
            stmt = coon.createStatement();
            rs = stmt.executeQuery("select * from student");

            while (rs.next()) {
                System.out.println(rs.getString("studentID") + " " + rs.getString("studentName"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (coon != null) coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
