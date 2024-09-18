package org.example.util;

import java.util.HashMap;
import org.example.model.Table;

public class Utilities {

  public static void createHashmapTables(HashMap<String, Table> tables) {
    for (int i = 1; i < 7; i++) {
      String tableName = "Table-" + i;
      tables.put(tableName, new Table(tableName, "", 4, false));
    }
  }

  public static void printStatusTables(HashMap<String, Table> tables,boolean onlyNotBusy){
    System.out.println();
    if(onlyNotBusy){
      System.out.println("Free tables");
    }else{
      System.out.println("All tables");
    }
    for(String tableName:tables.keySet()){
      boolean isBusy = tables.get(tableName).isBusy();
      if (!onlyNotBusy || !isBusy){
        System.out.println(tableName + ": " + isBusy);
      }
    }
  }

}
