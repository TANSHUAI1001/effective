package extend;

import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * Created by shuai on 2017/2/15.
 */
public class ExportDataTable {
    public static void main(String []args){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = statement.executeQuery(sql);
            String name = null;
            while(rs.next()) {
                name = rs.getString("stuName");
//                name = new String(name.getBytes("utf-8"),"utf-8");
                System.out.println(rs.getString("stuNo") + "\t" +
                        rs.getString("deptId") + "\t" + name);
            }

            rs.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }
}
