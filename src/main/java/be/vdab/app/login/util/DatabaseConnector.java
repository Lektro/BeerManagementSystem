package be.vdab.app.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

/** static import of login credentials */
import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseConnector {
    public DatabaseConnector dbConnect() {
        Connection conn = dbConnect();

        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established!");
            if (conn == null) {
                System.out.println("Connection could not be established!");
            }
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

