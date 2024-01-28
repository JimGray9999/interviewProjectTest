package api;

import models.Inventory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Test class for the Inventory class
 * @author: jimgray9999
 */
public class testInventory {
    ArrayList<Inventory> inventoryList;
    @BeforeTest
    public void testSetup() {
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("Boots", 79.95, 500));
    }


    /**
     * Test for successfully adding a new item to the inventoryList
     * @author: jimgray9999
     */
    @Test
    public void putAddItem() {
        try {
            inventoryList.add(new Inventory("Socks", 9.95, 600));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        printAllItems(inventoryList);
    }


    // TODO remove item
    /**
     * Test for successfully removing an item to the inventoryList
     * @author: jimgray9999
     */
    @Test
    public void removeItem() {
        System.out.println(inventoryList.toString());
    }

    // TODO update quantity
    @Test
    public void updateQuantity() {
        // add the number to the quantity
        // will either deduct if a negative number or add if positive
        System.out.println("Updated quantity of item.");
    }

    public void printAllItems(ArrayList<Inventory> arrListToPrint){
        for (Inventory inventory : arrListToPrint) {
            System.out.println(inventory.toString());
        }
    }
}
