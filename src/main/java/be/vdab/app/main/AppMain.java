package be.vdab.app.main;

import static be.vdab.app.searches.DatabaseSearchOnAlcoholVol.dbConnectSearchOnAlcoholVol;

public class AppMain {

    public static void main(String[] args) {
        // System.out.println("Test");
        //dbConnectSearchOnName();
        //dbConnectChangeStock();
        //dbConnectSearchOnName();
        dbConnectSearchOnAlcoholVol();
    }
}

// testrun on Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  50 Pcs in Stock  Brewer ID = 11 Category ID = 22
// after update --> Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  555 Pcs in Stock  Brewer ID = 11 Category ID = 22
// succes