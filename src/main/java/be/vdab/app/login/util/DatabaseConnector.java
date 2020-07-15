package be.vdab.app.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

/** static import of login credentials */
import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseConnector {
    public static DatabaseConnector dbConnect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established!");
            if (conn == null) {
                System.out.println("Connection could not be established!");
            }
            return dbConnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

