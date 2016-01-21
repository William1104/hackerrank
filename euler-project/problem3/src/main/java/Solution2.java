import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int t = scanner.nextInt();
            IntStream.rangeClosed(1, t).mapToLong(testNum -> {
                final long n = scanner.nextLong();
                return solve(n);
            }).forEach(System.out::println);
        }
    }

    public static long solve(long n, long r) {
        while (true) {
            if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n % r == 0) {
                // when n is r divisible.
                // the largest prime factor of n = the largest prime factor of n/r.
                n = n / r;

                // if n/r is reduce to 1, n = r before the division.
                // r is already the largest prime factor.
                if (n == 1) {
                    return r;
                }
            } else {
                // when n is not r divisible
                // and r is already greater than sqaure root of n.
                // then n is already the largest prime factor.
                if (r * r > n) {
                    return n;
                }

                // TODO, we may advance r by skipping all known non-prime number.
                if (r == 2) {
                    r = 3;
                } else {
                    r = r + 2;
                }
            }
        }
    }

    public static long solve(long n) {
        return solve(n, 2);
    }
}