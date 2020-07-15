package be.vdab.app;

import be.vdab.app.model.GetBeerNames;

import java.sql.SQLException;

public class AppMain {
    public static void main(String[] args) throws SQLException {


        // System.out.println("Test");
        // dbConnect();
        // Beer beer = new Beer(id);
        GetBeerNames gbn = new GetBeerNames();
        // gbn.toString();
    }
}
