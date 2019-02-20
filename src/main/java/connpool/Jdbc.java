package connpool;

import java.sql.*;

/**
 * Created by shuai on 2018/4/4.
 */
public class Jdbc {
    public static void main(String[] args) {
        try {
//            DriverManager.registerDriver(new Driver());
//            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shortener","root","root");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM dlt WHERE period > ?");
            ps.setString(1,"18010");
            ResultSet rs = ps.executeQuery();
//            Statement statement = conn.createStatement();
//            statement.execute("SELECT * FROM dlt WHERE period > 18010");
//            ResultSet rs = statement.getResultSet();

            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
