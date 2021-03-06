package be.vdab.app.searches;

import java.sql.*;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseSearchOnName {

    private static String userInput() {
        System.out.println(" Enter Search Term for Beer Name: ");
        Scanner sc = new Scanner(System.in);
        String searchVariable = sc.nextLine();
        return searchVariable;
    }

    public static Connection dbConnectSearchOnName() {

        Connection conn = null;
        String searchVariable = userInput();
        String sql = "SELECT Name, Id, Alcohol, Price, Stock, BrewerId, CategoryId FROM Beers WHERE Name LIKE '%" + searchVariable + "%'";

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