import java.sql.*;

/**
 * Created by tage on 15-8-22.
 */
public class TestBatch {
    public static void main(String[] args) {

        Connection coon = null;
        Statement stmt = null;
        PreparedStatement prepstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/testJDBC";

        try {
            coon = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        /*try {
            stmt = coon.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.addBatch("insert into student values ('0007', 'jj', 'female', '1313012')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.addBatch("insert into student values ('0008', 'jjk', 'male', '1313012')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.addBatch("insert into student values ('0009', 'jjkl', 'male', '1313012')");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != coon) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/


        try {
            prepstmt = coon.prepareStatement("insert into student values (?, ?, ?, ?)");
        } catch(SQLException e) {
            e.printStackTrace();
        }

        try {
            prepstmt.setString(1, "0010");
            prepstmt.setString(2, "f");
            prepstmt.setString(3, "male");
            prepstmt.setString(4, "1313012");
            prepstmt.addBatch();
            prepstmt.setString(1, "0011");
            prepstmt.setString(2, "g");
            prepstmt.setString(3, "male");
            prepstmt.setString(4, "1313012");
            prepstmt.addBatch();
            prepstmt.setString(1, "0012");
            prepstmt.setString(2, "h");
            prepstmt.setString(3, "male");
            prepstmt.setString(4, "1313012");
            prepstmt.addBatch();
            prepstmt.executeBatch();

        } catch(SQLException e) {
            e.printStackTrace();
        }


    }
}
