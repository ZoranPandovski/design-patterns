package app;
import app.strategies.PriceCounterStrategy;

import java.math.BigDecimal;
import java.util.List;

public class BasketPriceCounter {

    public BigDecimal calculatedPrice(List<Product> products, PriceCounterStrategy pricingStrategy) {

        BigDecimal sum = BigDecimal.ZERO;
        for(Product product: products){
            BigDecimal unitPrice = product.getUnitPrice();
            double quantity = product.getQuantity();

            BigDecimal productPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
            sum = sum.add(productPrice).subtract(pricingStrategy.productDiscount(product));
        }

        BigDecimal basketDiscount = pricingStrategy.discount(products, sum);
        sum = sum.subtract(basketDiscount);
        return sum;
    }
}
