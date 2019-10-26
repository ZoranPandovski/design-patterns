package app.strategies;

import app.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TeaDiscountStrategy implements PriceCounterStrategy {

    private BigDecimal discount;

    private int minNumOfItems;

    public TeaDiscountStrategy(BigDecimal discount, int minNumOfItems) {
        this.discount = discount;
        this.minNumOfItems = minNumOfItems;
    }

    @Override
    public BigDecimal productDiscount(Product product) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal discount(List<Product> products, BigDecimal basketPrice) {
        Set<Product> teaProduct = products.stream().filter(product -> product.getName().equals("tea")).filter(tea -> tea.getQuantity() > minNumOfItems).collect(Collectors.toSet());

        if(teaProduct.size() == 1) {
            Product tea = teaProduct.iterator().next();
            return tea.getUnitPrice().multiply(BigDecimal.valueOf(tea.getQuantity())).multiply(discount);
        }
        return BigDecimal.ZERO;
    }
}
