package models;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Atoll_db {

    private static final String conStrDB_39 = "jdbc:mysql://10.144.14.101:3306/DB_39" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true";

    private static Connection connect_39;

    public static void createConnection39() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect_39 = DriverManager.getConnection(conStrDB_39,
                "e2e_user", "v4U12Fl7Gb0s37vB");
    }

    static {
        try {
            createConnection39();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String conStr_42 = "jdbc:mysql://10.144.14.101:3306/DB_42" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true";

    private static Connection connect_42;

    public static void createConnection_42() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect_42 = DriverManager.getConnection(conStr_42,
                "e2e_user", "v4U12Fl7Gb0s37vB");
    }

    static {
        try {
            createConnection_42();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static final String conStr_43 = "jdbc:mysql://10.144.14.101:3306/DB_43" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true";

    private static Connection connect_43;

    public static void createConnection_43() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect_43 = DriverManager.getConnection(conStr_43,
                "e2e_user", "v4U12Fl7Gb0s37vB");
    }

    static {
        try {
            createConnection_43();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Atoll_db() throws IOException {
    }

    public static Connection CheckDb(String nameBD) {
        if (nameBD.equals("Astana") || nameBD.equals("Zhamb") || nameBD.equals("Kyzylorda") || nameBD.equals("Karaganda_42") || nameBD.equals("Kostanay") || nameBD.equals("SKO")
                || nameBD.equals("Turkestan"))
            return connect_42;
        else if (nameBD.equals("Almaty") || nameBD.equals("VKO") || nameBD.equals("Pavlodar") || nameBD.equals("Karaganda_43"))
            return connect_43;
        else if (nameBD.equals("Aktobe") || nameBD.equals("Atyrau") || nameBD.equals("Mangystau") || nameBD.equals("ZKO"))
            return connect_39;
        else return null;
    }
}
