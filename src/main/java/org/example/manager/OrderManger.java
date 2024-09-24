package org.example.manager;

import org.example.model.Menu;
import org.example.model.Order;
import org.example.model.Table;
import org.example.repository.RestaurantDB;
import org.example.utils.Utilities;
import org.example.view.TableDisplay;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderManger {

    public static void testOrder(RestaurantDB r1){

        ArrayList<Menu> m = new ArrayList<>();
        m.add(r1.getMenus().get("MENU-NIG"));
        m.add(r1.getMenus().get("MENU-NIG"));
        m.add(r1.getMenus().get("MENU-VEG"));
        m.add(r1.getMenus().get("MENU-KID"));

        Order o1 = new Order(new Date(), "Jazz", 4,
                0.0, false, r1.getTables().get("TABLE-01"), null);
        o1.setMenus(m);

        r1.getTables().get("TABLE-01").setBusy(true);

        System.out.println("Total to pay:"+ o1.calculateTotalPayment());
        System.out.println(o1);

        o1.setPaid(true);

        System.out.println(o1);
        r1.getTables().get("TABLE-01").setBusy(false);

        System.out.println("Table status (" +
                r1.getTables().get("TABLE-01").getName() +
                "):" + r1.getTables().get("TABLE-01").isBusy());


    }

    public static void payOrder(){

        //to-do
        //hashMap orders from r1
        //filter by TODAY and NOT-PAY
        //SELECT order from a loop: quit, option and unknown
        //get total payment
        // isPaid to TRUE

    }




    public static boolean createOrder(Scanner scanner, RestaurantDB r1){

        // create object
        Order order1 = new Order();

        // create date
        Date date = new Date();
        order1.setDate(date);

        // create waiter
        String waiter = Utilities.ask(scanner, "Waiter? ");
        order1.setWaiter(waiter);

        // people qty
        int qtyInt = Utilities.askInt(scanner, "People qty? ");

        // table selection
        // null => take away
        Table emptyTableSelected = EmptyTableSelectionManager.selectEmptyTable(scanner,r1);
        order1.setTable(emptyTableSelected);

        // menus selection
        ArrayList<Menu> menus = MenuSelectionManager.selectMenus(scanner,r1);
        order1.setMenus(menus);


        // total payment
        double totalPayment = order1.calculateTotalPayment();
        order1.setTotalPayment(totalPayment);

        // create paid
        order1.setPaid(false);

        // saver order to repo
        r1.getOrders().put("OR-001", order1);

        // Assure order has been saved
        // retrieve order from DB
        Order orderCheck = r1.getOrders().get("OR-001");

        System.out.println("\nOrder");
        System.out.println(order1);

        boolean ok = orderCheck.equals(order1);

        if (ok && emptyTableSelected != null){
            // if all was ok and is not a takeaway
            emptyTableSelected.setBusy(true);
        }

        return ok;
    }
}
