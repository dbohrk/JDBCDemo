package demo;

import java.sql.Connection;
import java.sql.Statement;

public class DBInsert2 {
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

        String empno = args[0];
        String ename = "'" + args[1] + "'";
        String salary = args[2];

        String insertCommand = "INSERT INTO Emp VALUES(" + empno + "," + ename + "," + salary + ")";
        int count = stm.executeUpdate(insertCommand);

        System.out.println(count + " Row(s) Inserted");
        DBUtil.close(stm);
        DBUtil.close(conn);
//        }
    }
}
