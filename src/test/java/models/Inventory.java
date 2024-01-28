package models;

public class Inventory {
    private Integer quantity;
    private String name;
    private Double price;

    public Inventory(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
