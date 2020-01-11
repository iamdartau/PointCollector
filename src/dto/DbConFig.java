package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConFig {

    private static final String conStr = "jdbc:mysql://1.2.3.4:3306/ROFL+" +
            "?useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
    // "?useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"

    public static Connection conn;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(conStr,
                "user", "password");
    }

    static {
        try {
            createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
