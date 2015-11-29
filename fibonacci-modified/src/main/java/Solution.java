import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();
            final int n = scanner.nextInt();
            System.out.println(Resolver.resolve(a, b, n));
        }

    }

    public static final class Resolver {
        public static BigInteger resolve(int a, int b, int n) {
            if (n == 1) {
                return BigInteger.valueOf(a);
            } else if (n == 2) {
                return BigInteger.valueOf(b);
            } else {
                final BigInteger fn_1 = resolve(a, b, n - 1);
                BigInteger fn_2 = resolve(a, b, n - 2);
                return fn_1.multiply(fn_1).add(fn_2);
            }
        }
    }
}


