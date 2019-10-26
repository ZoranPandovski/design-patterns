package app;

import app.strategies.FruitsDiscountStrategy;
import app.strategies.NormalPricesStrategy;
import app.strategies.PriceCounterStrategy;
import app.strategies.TeaDiscountStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasketApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("milk", Product.Category.dairy, new BigDecimal(1.1), 2));
        products.add(new Product("banana", Product.Category.fruit, new BigDecimal(2.1), 1.3));
        products.add(new Product("lemon", Product.Category.fruit, new BigDecimal(0.3), 0.2));
        products.add(new Product("coffee", Product.Category.teaAndCoffee, new BigDecimal(0.5), 1));
        products.add(new Product("betroot", Product.Category.vegetable, new BigDecimal(0.5), 1));
        products.add(new Product("tea", Product.Category.teaAndCoffee, new BigDecimal(0.2), 4));

        BasketPriceCounter priceCounter = new BasketPriceCounter();
        PriceCounterStrategy pricingStrategy = new NormalPricesStrategy();
        PriceCounterStrategy healthyWeekendStrategy = new FruitsDiscountStrategy(BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.05));
        PriceCounterStrategy teaDiscountStrategy = new TeaDiscountStrategy(BigDecimal.valueOf(0.1), 3);

        BigDecimal normalPrice = priceCounter.calculatedPrice(products, pricingStrategy);
        BigDecimal healthyWeekendPrice = priceCounter.calculatedPrice(products, healthyWeekendStrategy);
        BigDecimal teaWeekendPrice = priceCounter.calculatedPrice(products, teaDiscountStrategy);

        System.out.println(normalPrice);
        System.out.println(healthyWeekendPrice);
        System.out.println(teaWeekendPrice);
    }
}
