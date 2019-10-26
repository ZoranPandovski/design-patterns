package app.strategies;

import app.Product;

import java.math.BigDecimal;
import java.util.List;

public class NormalPricesStrategy implements PriceCounterStrategy {


    @Override
    public BigDecimal productDiscount(Product product) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal discount(List<Product> products, BigDecimal basketPrice) {
        return BigDecimal.ZERO;
    }
}
