import java.util.List;

public class DiscountStrategy implements BillingStrategy {
    private double discountPercentage;

    public DiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getTotal(List<Product> productList) {
        return productList.stream().mapToDouble(Product::getPrice).sum() * (1 - discountPercentage / 100) ;
    }
}