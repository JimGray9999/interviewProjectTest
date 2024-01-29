package models;

import java.util.ArrayList;

/**
 * Helper class to emulate CRUD operations related to the ecommerce inventory
 */
public class InventoryCrud {

    public void getInventory(ArrayList<Inventory> arrListToPrint){
        for (Inventory inventory : arrListToPrint) {
            System.out.println(inventory.getName());
            System.out.println(inventory.getPrice().toString());
            System.out.println(inventory.getQuantity().toString());
        }

    }

    public void postAddToInventory(){

    }

    public void putUpdateQuantity(){

    }
    public void delRemoveItem(){

    }


}
