package be.vdab.app.main;

import static be.vdab.app.main.MainMenu.mainMenu;

public class AppMain {

    public static void main(String[] args) {

        mainMenu();
    }
}

        // System.out.println("Test");
        // dbConnectSearchOnName();
        // dbConnectSearchOnAlcoholVol();
        // dbConnectChangeStock();
        // dbConnectSearchOnName();
        // dbConnectSearchOnID();
        // dbConnectChangePrice();
        // dbConnectSearchOnBrewerTurnover();
        // new DatabaseSearchOnName();
        // give all beers by producers with selected turnover? sql merge?
        // adjust price?? gives --> java.util.InputMismatchException
        // adjust price works could use a unit test I suppose
        //



// testrun on Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  50 Pcs in Stock  Brewer ID = 11 Category ID = 22
// after update --> Primeur kriek  ID Number: 1076 5.0 % VOL  2.55 EUR  555 Pcs in Stock  Brewer ID = 11 Category ID = 22
// succes with update price

// next option SELECT `brewers`.`Name`, `brewers`.`Turnover` FROM `beersdb`.`brewers` WHERE Turnover > '50000'; filter on turnover and get all their beers
//succes
// started building on the CLI menu structure
