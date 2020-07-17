package be.vdab.app.main;

import be.vdab.app.database.DatabaseChangePrice;
import be.vdab.app.database.DatabaseChangeStock;
import be.vdab.app.searches.*;

public class SecondaryMenu {
    public static SecondaryMenu secondaryMenuMenu() {
        // Local variable
        int swValue;

        // Display menu graphics
        System.out.println("=================================");
        System.out.println("|       Secondary Menu          |");
        System.out.println("=================================");
        System.out.println("| Options:                      |");
        System.out.println("| 1. Search on Name             |");
        System.out.println("| 2. Search on ID               |");
        System.out.println("| 3. Search on Alcohol VOL      |");
        System.out.println("| 4. Search Brewers on Turnover |");
        System.out.println("| 5. Search Beer on Stock       |");
        System.out.println("| 6. Change Beer Price by ID    |");
        System.out.println("| 7. Change Beer Stock by ID    |");
        System.out.println("| 8. Go to Secondary Menu       |"); //try to go to a new page in the menu?
        //System.out.println("| 9. ....                       |");show beers per brewer selected on turnover maybe?
        System.out.println("| 0. Exit to Main               |");
        System.out.println("=================================");

        swValue = Keyin.inInt(" Select option: ");

        /** Switch construct to go through the different options */
        switch (swValue) {
            case 1:
                DatabaseSearchOnName.dbConnectSearchOnName();
                MainMenu.mainMenu();
                break;
            case 2:
                DatabaseSearchOnID.dbConnectSearchOnID();
                MainMenu.mainMenu();
                break;
            case 3:
                DatabaseSearchOnAlcoholVol.dbConnectSearchOnAlcoholVol();
                MainMenu.mainMenu();
                break;
            case 4:
                DatabaseSearchBrewersOnTurnover.dbConnectSearchOnBrewerTurnover();
                MainMenu.mainMenu();
            case 5:
                DatabaseSearchOnStock.dbConnectSearchOnStock();
                MainMenu.mainMenu();
            case 6:
                DatabaseChangePrice.dbConnectChangePrice();
                System.out.println("Price update successful!");
                MainMenu.mainMenu();
                break;
            case 7:
                DatabaseChangeStock.dbConnectChangeStock();
                System.out.println("Stock update successful");
                MainMenu.mainMenu();
            case 0:
                MainMenu.mainMenu();
            default:
                MainMenu.mainMenu();
                break; // This break is not really necessary
        }
        return null;
    }
}
