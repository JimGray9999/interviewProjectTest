package models;

public class Inventory {
    private Integer quantity;

    private String name;

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Double price;

    public Integer getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public Inventory(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
