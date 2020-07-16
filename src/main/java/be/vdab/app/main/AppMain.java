package be.vdab.app.main;

import static be.vdab.app.database.DatabaseChangePrice.dbConnectChangePrice;
import static be.vdab.app.searches.DatabaseSearchOnName.dbConnectSearchOnName;

public class AppMain {

    public static void main(String[] args) {
        // System.out.println("Test");
        dbConnectSearchOnName();
        //dbConnectSearchOnAlcoholVol();
        //dbConnectChangeStock();
        //dbConnectSearchOnName();
        //dbConnectSearchOnID();
        dbConnectChangePrice();
        // give all beers by producers with selected turnover? sql merge?
        // adjust price??
        //
    }
}

// testrun on Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  50 Pcs in Stock  Brewer ID = 11 Category ID = 22
// after update --> Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  555 Pcs in Stock  Brewer ID = 11 Category ID = 22
// succes