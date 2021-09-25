package demo;

import java.sql.Connection;

public class DBDemo {
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
        System.out.println("Connection Ready");
        DBUtil.close(conn);
//        }
    }
}
