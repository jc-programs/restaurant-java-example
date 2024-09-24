package org.example.manager;

import org.example.model.Menu;
import org.example.repository.RestaurantDB;
import org.example.utils.Utilities;
import org.example.view.MenuDisplay;
import org.example.view.TableDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSelectionManager {

    private static ArrayList<Menu> getActiveMenus(RestaurantDB r1){
        ArrayList<Menu> menus = new ArrayList<>();
        return menus;
    }


    public static ArrayList<Menu> selectMenus(Scanner scanner, RestaurantDB r1) {
        ArrayList<Menu> activeMenus = new ArrayList<>();
        for(Menu menu:r1.getMenus().values()){
            if (menu.isActive()){
                activeMenus.add(menu);
            }
        }
        ArrayList<Menu> selectedMenus = new ArrayList<>();
        while(true) {
            MenuDisplay.showActiveMenus(activeMenus);
            int menuSelection = Utilities.askInt(scanner, "0 -> Quit. Menu? ");
            if(menuSelection == 0) {
                if( selectedMenus.isEmpty() ) System.out.println("You must select at least one menu!");
                else break;
            }else if (menuSelection> 0 && menuSelection <= activeMenus.size()){
                selectedMenus.add( activeMenus.get(menuSelection-1));
            } else {
                System.out.println("Wrong selection!");
            }
        }
        return selectedMenus;
    }

}
