import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by tage on 15-8-18.
 */
public class TestDML {
    public static void main(String[] args) {
        Connection coon = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testJDBC";
            coon = DriverManager.getConnection(url, "root", "root");
            stmt = coon.createStatement();
            stmt.executeUpdate("insert into student values ('0003','test','female','1313012')");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        }


    }
}
