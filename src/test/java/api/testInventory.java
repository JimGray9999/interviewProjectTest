package api;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import models.Inventory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Objects;

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
        extent.attachReporter(spark);
    }

    /**
     * Test to validate adding a new item to the inventoryList
     * @author: jimgray9999
     */
    @Test(dataProvider = "csvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void putAddItem(String testCaseName, String name, String price, String quantity) {
        ExtentTest test = extent.createTest("putAddItem: " + testCaseName);
        double testPrice = Double.parseDouble(price);
        int testQuantity = Integer.parseInt(quantity);
        inventoryList.add(new Inventory(name, testPrice, testQuantity));
        printAllItems(test, inventoryList);
        test.log(Status.PASS, "putAddItem: " + testCaseName + " passed.");
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
        ExtentTest test = extent.createTest("removeItem");
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
        test.log(Status.PASS, "removeItem passed");
    }

    /**
     * Test to validate updating an item quantity to the inventoryList
     * @author: jimgray9999
     */
    @Test
    public void updateQuantity() {
        ExtentTest test = extent.createTest("updateQuantity");
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
        test.log(Status.PASS, "updateQuantity passed");
    }

    /**
     * Helper method for printing out all inventory items
     *
     * @param arrListToPrint - the arrayList that should contain all the Inventory class items
     */
    public void printAllItems(ExtentTest test, ArrayList<Inventory> arrListToPrint){
        for (Inventory inventory : arrListToPrint)
            test.log(Status.INFO, inventory.toString());
    }

    @AfterTest
    public void tearDown(){
        extent.flush();
    }
}
