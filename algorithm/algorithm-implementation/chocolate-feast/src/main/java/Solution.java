import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int numOfTests = scanner.nextInt();
            IntStream.range(0, numOfTests).map(test -> {
                final int money = scanner.nextInt();
                final int price = scanner.nextInt();
                final int exchangeRate = scanner.nextInt();
                return Resolver.resolve(money, price, exchangeRate);
            }).forEach(System.out::println);
        }
    }

    public static final class Resolver {
        public static int resolve(
                final int money,
                final int chocolatePrice,
                final int exchangeRate) {

            int chocolates = money / chocolatePrice;
            int wrap = chocolates;

            while (wrap >= exchangeRate) {
                int exchangedChocolates = wrap / exchangeRate;
                chocolates += exchangedChocolates;
                wrap = wrap % exchangeRate + exchangedChocolates;
            }

            return chocolates;
        }
    }

}
