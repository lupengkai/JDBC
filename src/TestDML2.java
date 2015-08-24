import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tage on 15-8-19.
 */
public class TestDML2 {
    public static void main(String[] args) {
        if (args.length != 3)
            System.exit(-1);

        String studentID = args[0];
        String studentName = args[1];
        String sex = args[2];
        String classNum = args[3];

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

        String sql = "insert into student values ('" + studentID + "','" + studentName + "','" + sex + "','" + classNum + "')";
 System.out.println(sql);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != stmt)
                    stmt.close();
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
