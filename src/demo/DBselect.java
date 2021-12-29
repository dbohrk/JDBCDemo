package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBselect {
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


        Connection conn = DBUtil.getConnection();
        Statement stm = conn.createStatement();
       // String selectCommand = "SELECT * FROM Emp";
        String selectCommand = "SELECT Empno, Ename, Salary FROM Emp";

        ResultSet rs = stm.executeQuery(selectCommand);

        ResultSetMetaData rm = rs.getMetaData();

        int cols = rm.getColumnCount();

        System.out.println("Number of Columns: " + cols);

        for (int i = 1; i <= cols; i++)
        {
            System.out.print(rm.getColumnName(i) + "\t\t");

        }
        System.out.println();
        // System.out.println("Boolean: " + rs.next());
        while(rs.next())    // Top to Bottom
        {
            for (int i = 1; i <= cols; i++) // Left to Right
            {
                System.out.print(rs.getString(i) + "\t\t");
            }
            System.out.println();
        }

        DBUtil.close(rs);
        DBUtil.close(stm);
        DBUtil.close(conn);

    }
}
