import java.util.List;

public interface BillingStrategy {
    double getTotal(List<Product> productList);
}
