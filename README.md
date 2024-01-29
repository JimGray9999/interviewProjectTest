# eCommerce Test Suite

- Test Suite running test methods against a hypothetical ecommerce inventory management system

Dependencies Used:
  - TestNG - Framework for the tests
  - ExtentReports - to build custom test run reports
  - Commons CSV - for reading the data CSV into the tests
    
Methods:
- testAddItem
  - Test to validate adding a new item to the inventoryList
  - CSV file will run the test method against each added item
    
- testRemoveItem
  - Test to validate removing an item from the inventoryList, that matches a provided name search
- testUpdateQuantity
  - Test to validate updating an item quantity to the inventoryList

Models:
- Inventory
  - a model of the Inventory items, setup as a custom class
- InventoryCrud
  - mocks the API for the Inventory system and CRUD functionality
 

Future Enhancements:
- Migrate all test CRUD features from test methods and into InventoryCrud class
- Add data provider to remaining test methods
- Run data provider with a data file for each test method
- Add assertions to validate changes were made as expected
- Update testRemoveItem method to also remove any item that matches the item name provided
- Add user management tests, to create sellers that can maintain their own inventories
