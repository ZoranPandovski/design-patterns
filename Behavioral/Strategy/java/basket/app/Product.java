package app;
import java.math.BigDecimal;

public class Product {

    public enum Category {
        fruit,
        vegetable,
        dairy,
        drinks,
        teaAndCoffee
    }

    private String name;

    private BigDecimal unitPrice;

    private double quantity;

    private Category category;


    public Product(String name, Category category, BigDecimal unitPrice, double quantity) {
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }
}
