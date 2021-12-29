package demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
    private static String jdbcUrl;
    private static boolean isInitialized;

    private static void initialize() {
        if (!isInitialized) {
            try {
                Properties properties = new Properties();
                // Get resource values from a file - jdbc.properties in this case
                InputStream source = DBUtil.class.getResourceAsStream("jdbc.properties");
                properties.load(source);
                source.close();
                jdbcUrl = properties.getProperty("jdbcUrl");
                isInitialized = true;
            } catch (Exception e) {
                System.err.println("Error while initializing JDBC…");
            }
        }
    }

    public static Connection getConnection() throws Exception
    {
        initialize();
        return DriverManager.getConnection(jdbcUrl);
    }

    public static void close(ResultSet rs) throws Exception
    {
        if (rs != null)
            rs.close();
    }

    public static void close(Statement stm) throws Exception
    {
        if (stm != null)
            stm.close();
    }

    public static void close(Connection conn) throws Exception
    {
        if (conn != null)
            conn.close();
    }
}
