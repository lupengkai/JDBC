import java.sql.*;

/**
 * Created by tage on 15-8-22.
 */
public class TestUpdateRs {
    public static void main(String[] args) {
        Connection coon = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url = "jdbc:mysql://localhost:3306/testJDBC";
            coon = DriverManager.getConnection(url, "root", "root");
            stmt = coon.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            rs = stmt.executeQuery("select * from student ");
            rs.next();

            //update
            rs.updateString(1, "0080");
            rs.updateRow();

            //insert
            rs.moveToInsertRow();
            rs.updateString(1, "0888");
            rs.updateString(2, "jkjk");
            rs.updateString(3, "male");
            rs.updateString(4, "1313012");
            rs.insertRow();
            rs.moveToCurrentRow();

            //delete
            rs.deleteRow();


            //cancel  current update
            rs.cancelRowUpdates();

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
