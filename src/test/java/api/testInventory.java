package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import models.Inventory;
import models.InventoryCrud;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Test class for running tests against the Inventory system
 * @author: jimgray9999
 */
public class testInventory {
    ArrayList<Inventory> inventoryList;
    InventoryCrud inventoryCrud = new InventoryCrud();
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/TestReport.html");

    @BeforeTest
    public void testSetup() {
        inventoryList = new ArrayList<>();
        extent.attachReporter(spark);
    }

    /**
     * Test to validate adding a new item to the inventoryList
     * @author: jimgray9999
     */
    @Test(dataProvider = "csvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void testAddItem(String testCaseName, String name, String price, String quantity) {
        ExtentTest test = extent.createTest("testAddItem: " + testCaseName);
        double testPrice = Double.parseDouble(price);
        int testQuantity = Integer.parseInt(quantity);
        inventoryList.add(new Inventory(name, testPrice, testQuantity));
        inventoryCrud.getInventory(inventoryList);
        printAllItems(test, inventoryList);
        test.log(Status.PASS, "testAddItem: " + testCaseName + " passed.");
    }

    /**
     * Test to validate removing an item from the inventoryList that matches name
     * first
     * @author: jimgray9999
     *
     */
    @Test
    public void testRemoveItem() {
        ExtentTest test = extent.createTest("testRemoveItem");
        inventoryList.add(new Inventory("Boots", 56.97, 1600));
        String itemToRemove = "Boots";
        test.log(Status.INFO, "Inventory before removal:");
        printAllItems(test, inventoryList);

        for (Inventory inventory : inventoryList) {
            if(Objects.equals(inventory.getName(), itemToRemove)){
                test.log(Status.INFO, "Found record: " + itemToRemove + ", removing.");
                inventoryList.remove(inventory);
                break;
            }
        }
        test.log(Status.INFO,"Inventory after removal:");
        printAllItems(test, inventoryList);
        test.log(Status.PASS, "testRemoveItem passed");
    }

    /**
     * Test to validate updating an item quantity to the inventoryList
     * @author: jimgray9999
     */
    @Test
    public void testUpdateQuantity() {
        ExtentTest test = extent.createTest("testUpdateQuantity");
        inventoryList.add(new Inventory("Boots", 56.97, 1600));
        String itemToUpdate = "Boots";
        int newQuantity = 1700;

        test.log(Status.INFO, "Inventory Before update:");
        printAllItems(test, inventoryList);
        for (Inventory inventory : inventoryList) {
            if(Objects.equals(inventory.getName(), itemToUpdate)){
                test.log(Status.INFO,"Found " + itemToUpdate + " will update quantity.");
                inventory.setQuantity(newQuantity);
            } else {
                System.out.println("Item not found");
            }
            test.log(Status.INFO, "Inventory After update:");
            printAllItems(test, inventoryList);

        }
        test.log(Status.PASS, "testUpdateQuantity passed");
    }

    /**
     * Helper method for printing out all inventory items
     *
     * @param arrListToPrint - the arrayList that should contain all the Inventory class items
     */
    private void printAllItems(ExtentTest test, ArrayList<Inventory> arrListToPrint){
        for (Inventory inventory : arrListToPrint)
            test.log(Status.INFO, inventory.toString());
    }

    @AfterMethod
    public void cleanUp(){
        extent.flush();
        inventoryList.clear();
    }
}
