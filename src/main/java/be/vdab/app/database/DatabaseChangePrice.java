package be.vdab.app.database;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class DatabaseChangePrice {

    private static int userInputBeerID() {
        System.out.println("Enter the ID number of the beer you want to update: ");
        Scanner sc = new Scanner(System.in);
        int idToUpdate = sc.nextInt();
        return idToUpdate;
    }
    private static String userInputPrice() {
        System.out.println("Enter the new price for this Beer: ");
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0,00");
        float priceToUpdate = sc.nextFloat();
        return df.format(priceToUpdate);
    }
    public static Connection dbConnectChangePrice() {

        Connection conn = null;
        int beerIdToUpdate = userInputBeerID();
        String priceToUpdate = userInputPrice();
        String sql = String.format("UPDATE Beers SET Price = %s WHERE Id = %d ", priceToUpdate, beerIdToUpdate);

        try {
            conn = DriverManager.getConnection(url, user, pass);
            {
                System.out.println("Connection established!");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                int rs = st.executeUpdate(sql);
                System.out.println(rs);
                return conn;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
