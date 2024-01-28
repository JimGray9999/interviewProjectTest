package api;

import models.Inventory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class testInventory {
    ArrayList<Inventory> inventoryList;
    @BeforeTest
    public void testSetup() {
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("Boots", 79.95, 500));
    }

    @Test
    public void putAddItem() {
        try {
            inventoryList.add(new Inventory("Socks", 9.95, 600));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(inventoryList.get(0).toString());
        System.out.println(inventoryList.get(1).toString());
    }


    // TODO remove item
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
}
