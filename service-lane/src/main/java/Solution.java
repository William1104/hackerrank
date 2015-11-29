import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int lengthOfFreeway = scanner.nextInt();
            int numOfTestCase = scanner.nextInt();
            int[] widths = IntStream.range(0, lengthOfFreeway)
                    .map(i -> scanner.nextInt())
                    .toArray();

            final Resolver resolver = new Resolver(lengthOfFreeway, widths);

            IntStream.range(0, numOfTestCase).map(testNum -> {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                return resolver.resolve(start, end);
            }).forEach(System.out::println);
        }


    }

    public static final class Resolver {
        private final int lengthOfFreeway;
        private final int[] widths;

        public Resolver(final int lengthOfFreeway, final int[] widths) {
            super();
            this.lengthOfFreeway = lengthOfFreeway;
            this.widths = Arrays.copyOf(widths, lengthOfFreeway);
        }

        public int resolve(int start, int end) {
            int max = widths[start];
            for (int i = start + 1; i <= end; i++) {
                max = Math.min(max, widths[i]);
            }
            return max;
        }
    }
}
