package be.vdab.app.searches;

import java.sql.*;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseSearchOnAlcoholVol {

    private static double userInputDouble() {
        System.out.println(" Input number to search by Alcohol VOL:  ");
        Scanner sc = new Scanner(System.in);
        double searchDouble = sc.nextDouble();

        return searchDouble;
    }

    public static Connection dbConnectSearchOnAlcoholVol() {

        Connection conn = null;
        double searchVariable = userInputDouble();
        String sql = "SELECT Name, Id, Alcohol, Price, Stock, BrewerId, CategoryId FROM Beers WHERE Alcohol = " + searchVariable + "";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            {
                System.out.println("Connection established!");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sql);

                /** While there are matches found print out the result */
                while (rs.next()) {
                    String beerName = rs.getString(1);
                    int id = rs.getInt(2);
                    double alcohol = rs.getDouble(3);
                    double price = rs.getDouble(4);
                    int stock = rs.getInt(5);
                    int BrewerId = rs.getInt(6);
                    int CategoryId = rs.getInt(7);
                    System.out.format("%s %s %s %s %s %s %s%n", beerName + " -- ", "ID Number: " + id," % VOL: "+  alcohol," EUR: " + price,
                            "Total Stock: " + stock, "Brewer ID: " + BrewerId, "Category ID: " + CategoryId);
                }
                return conn;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
