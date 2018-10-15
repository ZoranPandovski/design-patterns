import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class for strategy pattern leveraging Java8 lambdas
 */
public class DiscounterDemo {

    public static void main(String[] args) {
        Discounter christmasDiscounter = Discounter.christmasDiscounter();
        Discounter newYearDiscounter = Discounter.newYearDiscounter();
        Discounter easterDiscounter = Discounter.easterDiscounter();

        List<Discounter> discounters = Arrays.asList(christmasDiscounter, newYearDiscounter, easterDiscounter);

        // Second way of creating list of discounters. Keeping the lambdas inline
        // The below is the same as providing the implementation in above Discounters interface
        List<Discounter> discountersInLine = Arrays.asList(
                amount -> amount.multiply(BigDecimal.valueOf(0.9)),
                amount -> amount.multiply(BigDecimal.valueOf(0.5)),
                amount -> amount.multiply(BigDecimal.valueOf(0.8))
        );

        BigDecimal originalAmount = new BigDecimal(100);

        BigDecimal christmasDiscAmount = christmasDiscounter.apply(originalAmount);

        System.out.println("Discounted amount with christmas discount: " + christmasDiscAmount);

        BigDecimal newYearDiscAmount = newYearDiscounter.apply(originalAmount);

        System.out.println("Discounted amount with new year discount: " + newYearDiscAmount);

        BigDecimal easterDiscAmount = easterDiscounter.apply(originalAmount);

        System.out.println("Discounted amount with easter discount: " + easterDiscAmount);

        // The first argument represents the identity. Its use is to return the unchanged value as default when no discounts are provided.
        // The second argument represents a BinaryOperator which combines the discounters in the list provided and returns the cumulative discount
        Discounter combinedDiscounter = discounters.stream().reduce(v -> v, Discounter::combine);

        BigDecimal combinedDiscAmount = combinedDiscounter.apply(originalAmount);

        System.out.println("Discounted amount with combined discount: " + combinedDiscAmount);

        // Combining the discounts of the inline discounter to show the same results as the above
        Discounter combinedDiscounterInLine = discountersInLine.stream().reduce(v -> v, Discounter::combine);

        BigDecimal combinedDiscAmountInLine = combinedDiscounterInLine.apply(originalAmount);

        System.out.println("Discounted amount with combined discount in line: " + combinedDiscAmountInLine);
    }
}