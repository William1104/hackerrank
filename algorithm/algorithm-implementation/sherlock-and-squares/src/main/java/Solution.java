import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int numOfTests = in.nextInt();
            IntStream.range(0, numOfTests).map(testNum ->
                    Resolver.resolve(in.nextLong(), in.nextLong())).forEach(System.out::println);
        }

    }

    public static final class Resolver {
        public static int resolve(long lowerBound, long upperBound) {
            int sqrtBelowUpperBound = (int) Math.floor(Math.sqrt(upperBound));
            int sqrtAboveUpperBound = (int) Math.ceil(Math.sqrt(lowerBound));

            return sqrtBelowUpperBound - sqrtAboveUpperBound + 1;
        }
    }
}
