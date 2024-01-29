package models;

public class Inventory {
    private Integer quantity;
    private String name;
    private Double price;

    // Constructor
    public Inventory(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters //
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
