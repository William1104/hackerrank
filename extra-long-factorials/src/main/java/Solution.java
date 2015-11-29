import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int n = scanner.nextInt();
            System.out.println(Resolver.resolve(n));
        }

    }

    public static final class Resolver {
        public static BigInteger resolve(int input) {
            return LongStream.rangeClosed(1, input)
                    .parallel()
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger::multiply)
                    .orElse(BigInteger.ONE);
        }
    }
}


