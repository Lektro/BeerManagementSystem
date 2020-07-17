package be.vdab.app.main;

import be.vdab.app.database.DatabaseChangePrice;
import be.vdab.app.database.DatabaseChangeStock;
import be.vdab.app.searches.DatabaseSearchOnAlcoholVol;
import be.vdab.app.searches.DatabaseSearchOnID;
import be.vdab.app.searches.DatabaseSearchOnName;

public class MainMenu {

    public static MainMenu mainMenu() {
        // Local variable
        int swValue;

        // Display menu graphics
        System.out.println("=================================");
        System.out.println("|     Beer Inventory System     |");
        System.out.println("=================================");
        System.out.println("| Options:                      |");
        System.out.println("| 1. Search on Name             |");
        System.out.println("| 2. Search on ID               |");
        System.out.println("| 2. Search on Alcohol VOL      |");
        System.out.println("| 3. Search Brewers on Turnover |");
        System.out.println("| 4. Change Beer Price by ID    |");
        System.out.println("| 5. Change Beer Stock by ID    |");
        System.out.println("| 6. ....                       |");
        System.out.println("| 7. ....                       |");
        System.out.println("| 8. ....                       |");
        System.out.println("| 9. ....                       |");
        System.out.println("| 0. Exit                       |");
        System.out.println("=================================");
        swValue = Keyin.inInt(" Select option: ");

        /** Switch construct to go through the diffrent options */
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
                DatabaseChangePrice.dbConnectChangePrice();
                MainMenu.mainMenu();
                break;
            case 5:
                DatabaseChangeStock.dbConnectChangeStock();
                MainMenu.mainMenu();
            default:
                MainMenu.mainMenu();
                break; // This break is not really necessary
        }
        return null;
    }
}
