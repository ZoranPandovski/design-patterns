import java.math.BigDecimal;
import java.util.function.UnaryOperator;

/**
 * Discounter defined as a functional interface.
 * Adding in the implementations of the discounterstrategy based on
 * the holiday season discounts.
 * We are using the static method implementations introduced in Java8
 * Extends the Unary operator which returns the same type of output as input
 * This leverages the use of combine which can combine results of two discounters
 * and return a cumulative discount
 */

public interface Discounter extends UnaryOperator<BigDecimal>{
    BigDecimal apply(BigDecimal amount);

    // Creates anonymous class for Discount overriding the apply method with the provided implementation
    static Discounter christmasDiscounter(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }

    static Discounter newYearDiscounter(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }

    static Discounter easterDiscounter(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }

    // Combines the results of the discounts to apply multiple discounts
    // Leverages the default methods for interfaces introduced in Java8
    default Discounter combine(Discounter after){
        return value -> after.apply(this.apply(value));
    }
}
