package be.vdab.app.searches;

import java.sql.*;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseSearchBrewersOnTurnover {

    private static int userInput() {
        System.out.println("Search all brewers with a turnover higher then: Please enter a turnover value... ");
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public static Connection dbConnectSearchOnBrewerTurnover() {

        Connection conn = null;
        int searchVariable = userInput();
        String sql = "SELECT `brewers`.`Name`, `brewers`.`Turnover` FROM `beersdb`.`brewers` WHERE Turnover > '" + searchVariable + "' ORDER BY `brewers`.`Turnover` DESC;";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            {
                System.out.println("Connection established!");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sql);

                /** While there are matches found print out the result */
                while (rs.next()) {
                    String brewerName = rs.getString(1);
                    int totalTurnover = rs.getInt(2);
                    //double alcohol = rs.getDouble(3);
                    //double price = rs.getDouble(4);
                    //int stock = rs.getInt(5);
                    //int BrewerId = rs.getInt(6);
                    //int CategoryId = rs.getInt(7);
                    System.out.format("%s %s%n", brewerName + " -- ", "Total turnover: " + totalTurnover);
                }
                return conn;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
