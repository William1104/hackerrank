import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 12/9/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int numOfTest = scanner.nextInt();
            IntStream.range(0, numOfTest).mapToObj(testNum -> {
                final int n = scanner.nextInt();
                final int a = scanner.nextInt();
                final int b = scanner.nextInt();
                return Resolver.resolve(n, a, b);
            }).forEach(output -> {
                IntStream.of(output).forEach(i -> System.out.print("" + i + " "));
                System.out.println();
            });
        }
    }

    public static class Resolver {
        public static int[] resolve(int n, int a, int b) {
            final int[] output = new int[n];
            return IntStream.range(0, n).map(i -> {
                final int min_ab = Math.min(a, b);
                final int max_ab = Math.max(a, b);
                return i * (max_ab) + (n - 1 - i) * min_ab;
            }).distinct().toArray();
        }
    }
}
