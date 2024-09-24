package org.example.view;

import org.example.model.Menu;

import java.util.List;

public class MenuDisplay {

    public static void ShowCRUDMenu(){

        // CRUD to manage MENU objects
    }

    public static void showActiveMenus(List<Menu> menus){
        for(int i =0;i<menus.size();i++){
            System.out.println((i+1) + " - " + menus.get(i).getName());
        }
    }
}
