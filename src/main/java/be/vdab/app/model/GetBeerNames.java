package be.vdab.app.model;

import java.sql.*;
import java.util.Scanner;

import static be.vdab.app.login.util.LoginCredentials.*;

public class GetBeerNames {

    public GetBeerNames() throws SQLException {}

    String searchVariable = userInput();

    public static String userInput() {
        System.out.println(" Enter Search Term: ");
        Scanner sc = new Scanner(System.in);
        String searchVariable = sc.nextLine();
        return searchVariable;
    }
    /** SQL Statement comes here */
    String sql = "SELECT Name FROM Beers WHERE Name LIKE '%" + searchVariable + "%'";

    /** Open connection with the local database using the ConnectionUtil for credentials */
    /** needs to be replaced by util */
    Connection con = DriverManager.getConnection(url, user, pass); {
    System.out.println("Connection Established! ");

    /** Statement */
    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = st.executeQuery(sql);

    /** While there are matches found print out the result */
    while (rs.next()) {
        String beerName = rs.getString(1);
        System.out.format("%s%n", beerName);
    }
    }
}