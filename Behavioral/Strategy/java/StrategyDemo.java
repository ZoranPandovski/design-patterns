import java.util.Arrays;
import java.util.List;

public class StrategyDemo {
    public static void main(String[] args) {
        Product productA = new Product("Product A", 20);
        Product productB = new Product("Product B", 10);
        List<Product> productList = Arrays.asList(productA, productB);

        BillingStrategy normalStrategy = new NormalStrategy();
        System.out.println(normalStrategy.getTotal(productList));

        BillingStrategy discountStrategy = new DiscountStrategy(10);
        System.out.println(discountStrategy.getTotal(productList));
    }
}
