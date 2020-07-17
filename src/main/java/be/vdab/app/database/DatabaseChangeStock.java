package be.vdab.app.database;

import java.sql.*;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseChangeStock {

    private static int userInputBeerID() {
        System.out.println("Enter the ID number of the beer you want to update: ");
        Scanner sc = new Scanner(System.in);
        int nameToUpdate = sc.nextInt();

        return nameToUpdate;
    }

    private static int userInputStockQuant() {
        System.out.println("Enter the quantity you want to update the stock to: ");
        Scanner sc = new Scanner(System.in);
        int beerIdToUpdate = sc.nextInt();

        return beerIdToUpdate;
    }

    public static Connection dbConnectChangeStock() {

        Connection conn = null;
        int beerIdToUpdate = userInputBeerID();
        int stockAmountToUpdate = userInputStockQuant();

        String sql = String.format("UPDATE Beers SET Stock = %d WHERE ID = %d ", stockAmountToUpdate, beerIdToUpdate);

        try {
            conn = DriverManager.getConnection(url, user, pass);
            {
                System.out.println("Connection established!");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                int rs = st.executeUpdate(sql);
                //System.out.println(rs);
                return conn;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
}
