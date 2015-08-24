import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tage on 15-8-22.
 */
public class TestTransaction {
    public static void main(String[] args) {
        Connection coon = null;
        Statement stmt = null;
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
        try {
            stmt = coon.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            coon.setAutoCommit(false);
            stmt.addBatch("insert into student values ('0020', 'jj', 'female', '1313012')");
            stmt.addBatch("insert into student values ('0021', 'jjk', 'male', '1313012')");
            stmt.addBatch("insert into student values ('0022', 'jjkl', 'male', '1313012')");
            stmt.executeBatch();
            coon.commit();
            coon.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                if (null != coon) {
                    coon.rollback();
                    coon.setAutoCommit(true);
                }
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        } finally {

            try {
                if (null != stmt) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (null != coon)
                    coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
