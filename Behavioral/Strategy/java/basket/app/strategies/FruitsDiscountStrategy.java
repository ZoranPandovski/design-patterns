package app.strategies;

import app.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitsDiscountStrategy implements PriceCounterStrategy {

    private BigDecimal fruitDiscount;

    private BigDecimal basketDiscount;

    public FruitsDiscountStrategy(BigDecimal fruitDiscount, BigDecimal basketDiscount) {
        this.fruitDiscount = fruitDiscount;
        this.basketDiscount = basketDiscount;
    }

    @Override
    public BigDecimal productDiscount(Product product) {
        if(Product.Category.fruit == product.getCategory()) {
                return product.getUnitPrice().multiply(BigDecimal.valueOf(product.getQuantity())).multiply(fruitDiscount);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal discount(List<Product> products, BigDecimal basketPrice) {
        if(basketPrice.compareTo(BigDecimal.TEN) == -1) {
            Set<Product.Category> categories = products.stream()
                    .filter(product -> Product.Category.fruit == product.getCategory() || Product.Category.vegetable == product.getCategory())
                    .map(Product::getCategory)
                    .collect(Collectors.toSet());
            if(categories.size() == 2) {
                return basketPrice.multiply(basketDiscount);
            }
        }
        return BigDecimal.ZERO;
    }
}
