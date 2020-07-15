package be.vdab.app.login.util;

import java.sql.Connection;
import java.sql.DriverManager;

/** static import of login credentials */
import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseConnector {

    public static Connection dbConnect() {

        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established!");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection could not be established!");
        }
        return null;
    }
}

