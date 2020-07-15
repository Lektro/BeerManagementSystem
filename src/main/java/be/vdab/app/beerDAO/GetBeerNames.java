package be.vdab.app.beerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** static import of login credentials */
import static be.vdab.app.login.util.LoginCredentials.*;

public class GetBeerNames {

    private int id;
    private String name;
    private float price;
    private int stock;
    private float alcohol;

    /** write your sql statements here */
    String sql = "SELECT Name, Alcohol, Price, Stock, BrewerId, CategoryId FROM Beers WHERE Name like 'Nie%'";

    /** attempt connection to DB */
        try (
    Connection con = DriverManager.getConnection(url, user, pass);  {
        System.out.println("Connection OK");

        /** statements here */
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String beerName = rs.getString(1);
            double alcohol = rs.getDouble(2);
            double price = rs.getDouble(3);
            int stock = rs.getInt(4);
            int BrewerId = rs.getInt(5);
            int CategoryId = rs.getInt(6);
            System.out.format("%s %s %s %s %s %s%n", beerName, alcohol + " % VOL ", price + " EUR ", stock + " Pcs in Stock ", "Brewer ID = " + BrewerId, "Category ID = " + CategoryId);
        }
    } catch (Exception ex) {
        System.out.println("Something went wrong!");
        ex.printStackTrace(System.err);
    }
}