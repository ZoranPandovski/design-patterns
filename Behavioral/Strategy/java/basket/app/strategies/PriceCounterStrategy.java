package app.strategies;

import app.Product;

import java.math.BigDecimal;
import java.util.List;

public interface PriceCounterStrategy {

    BigDecimal productDiscount(Product product);

    BigDecimal discount(List<Product> products, BigDecimal basketPrice);
}
