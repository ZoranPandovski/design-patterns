import java.util.List;

public class NormalStrategy implements BillingStrategy {
    @Override
    public double getTotal(List<Product> productList) {
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }
}
