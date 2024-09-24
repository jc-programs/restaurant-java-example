package org.example.manager;

import org.example.model.Table;
import org.example.repository.RestaurantDB;
import org.example.utils.Utilities;
import org.example.view.TableDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class EmptyTableSelectionManager {

    public static Table selectEmptyTable(Scanner scanner, RestaurantDB r1) {
        ArrayList<Table> emptyTables = new ArrayList<>();
        Table takeAwayTable = new Table();
        takeAwayTable.setName("Take away");
        emptyTables.add(takeAwayTable);
        for(Table table:r1.getTables().values()){
            if (!table.isBusy()){
                emptyTables.add(table);
            }
        }
        int tableSelection;
        while(true) {
            TableDisplay.showEmptyTables(emptyTables);
            tableSelection = Utilities.askInt(scanner, "Table? ");
            if (tableSelection>= 0 && tableSelection < emptyTables.size())
                break;
            System.out.println("Wrong table selection!");
        }
        return tableSelection == 0 ? null : emptyTables.get(tableSelection);
    }
}
