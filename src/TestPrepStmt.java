import java.sql.*;

/**
 * Created by tage on 15-8-19.
 */
public class TestPrepStmt {
    public static void main(String[] args) {
        if (args.length != 4)
            System.exit(-1);

        String studentID = args[0];
        String studentName = args[1];
        String sex = args[2];
        String classNum = args[3];

        Connection coon = null;
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

        try {
            prepstmt = coon.prepareStatement("insert into student values (?, ?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prepstmt.setString(1, studentID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prepstmt.setString(2, studentName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prepstmt.setString(3, sex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prepstmt.setString(4, classNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prepstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != prepstmt)
                    prepstmt.close();
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
