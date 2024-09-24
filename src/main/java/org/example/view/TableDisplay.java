package org.example.view;

import java.util.List;
import org.example.model.Table;

public class TableDisplay {

    public static void ShowCRUDtable(){

        // CRUD  to manage TABLE  objects
    }

    public static void showEmptyTables(List<Table> tables){
        for(int i =0;i<tables.size();i++){
            System.out.println(i + " - " + tables.get(i).getName());
        }
    }
}
