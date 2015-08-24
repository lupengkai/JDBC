import java.sql.*;

/**
 * Created by tage on 15-8-22.
 */
public class TestScroll {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection coon = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/testJDBC";
            coon = DriverManager.getConnection(url, "root", "root");
            stmt = coon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from student order by S");
            rs.next();
            System.out.println(rs.getString(1));
            System.out.println(rs.isFirst());
            rs.last();
            System.out.println(rs.isLast());
            System.out.println(rs.getRow());
            rs.previous();
            System.out.println(rs.getString(1));
            rs.absolute(6);
            System.out.println(rs.getString(1));



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
