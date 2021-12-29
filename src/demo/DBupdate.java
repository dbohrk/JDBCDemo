package demo;

import java.sql.Connection;
import java.sql.Statement;

public class DBupdate {
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
        String updateCommand = "UPDATE Emp SET Ename = 'Kahuna' WHERE Ename = 'Super-Dave'";
        int count = stm.executeUpdate(updateCommand);

        System.out.println(count + " Row(s) Updated");
        DBUtil.close(stm);
        DBUtil.close(conn);
//        }
    }
}
