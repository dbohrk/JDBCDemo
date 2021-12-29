package demo;

import java.sql.Connection;
import java.sql.Statement;

public class DBdelete {
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/dave";
        // String user ="root";
        // String password = "password";

//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password","password");
//
//        // Optional statement to load driver
//        String driverClass = "com.mysql.jdbc.Driver";
//        Class.forName(driverClass);

//        try(Connection conn = DriverManager.getConnection(url, properties)) {\
        Connection conn = DBUtil.getConnection();
        Statement stm = conn.createStatement();
        String deleteCommand = "DELETE FROM  Emp WHERE EmpNo = 101";
        int count = stm.executeUpdate(deleteCommand);

        System.out.println(count + " Row(s) Deleted");
        DBUtil.close(stm);
        DBUtil.close(conn);
//        }
    }
}
