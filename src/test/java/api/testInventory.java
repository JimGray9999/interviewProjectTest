package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
    ExtentReports extent = new ExtentReports();

    ExtentSparkReporter spark = new ExtentSparkReporter("target/TestReport.html");

    @BeforeTest
    public void testSetup() {
        inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("Boots", 79.95, 500));
        inventoryList.add(new Inventory("Boots", 79.95, 600));
    }

    /**
     * Test to validate adding a new item to the inventoryList
     * @author: jimgray9999
     */
    @Test(dataProvider = "csvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void putAddItem(String name, String price, String quantity) {
        Double testPrice = Double.parseDouble(price);
        Integer testQuantity = Integer.parseInt(quantity);
        inventoryList.add(new Inventory(name, testPrice, testQuantity));
        printAllItems(inventoryList);
        extent.attachReporter(spark);
        extent.createTest("putAddItem")
                .log(Status.PASS, "Item added successfully");
        extent.flush();
    }

    /**
     * Test to validate removing an item from the inventoryList that matches name
     * first
     * @author: jimgray9999
     *
     */
    // TODO: Remove each item that matches the name
    @Test
    public void removeItem() {
        String itemToRemove = "Boots";
        System.out.println("Inventory before removal:");
        printAllItems(inventoryList);
        for (Inventory inventory : inventoryList) {
            if(inventory.getName() == itemToRemove){
                System.out.println("found " + itemToRemove + " will remove.");
                inventoryList.remove(inventory);
            }
        }
        System.out.println("Inventory after removal:");
        printAllItems(inventoryList);
        extent.createTest("removeItem")
                .log(Status.PASS, "Item removed");
        extent.flush();
    }

    /**
     * Test to validate updating an item quantity to the inventoryList
     * @author: jimgray9999
     */
    @Test
    public void updateQuantity() {
        String itemToUpdate = "Boots";
        int newQuantity = 1700;

        // add the number to the quantity
        // will either deduct if a negative number or add if positive
        printAllItems(inventoryList);
        for (Inventory inventory : inventoryList) {
            if(inventory.getName() == itemToUpdate){
                System.out.println("found " + itemToUpdate + " will update quantity.");
                inventory.setQuantity(newQuantity);
            } else {
                System.out.println("Item not found");
            }

            printAllItems(inventoryList);

        }
        extent.createTest("updateQuantity")
                .log(Status.PASS, "updateQuantity passed");
        extent.flush();
    }

    /**
     * Helper method for printing out all inventory items
     *
     * @param arrListToPrint - the arrayList that should contain all the Inventory class items
     */
    public void printAllItems(ArrayList<Inventory> arrListToPrint){
        for (Inventory inventory : arrListToPrint) {
            System.out.println(inventory.toString());
        }
    }
}
