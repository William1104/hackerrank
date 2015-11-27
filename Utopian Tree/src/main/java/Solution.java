import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int numberOfTest = in.nextInt();

            IntStream.range(0, numberOfTest).mapToObj(testNumber -> {
                        final int cycle = in.nextInt();
                        return String.valueOf(Resolver.resolve(cycle));
                    }
            ).forEach(System.out::println);
        }
    }

    public static final class Resolver {
        public static long resolve(int numOfCycle) {
            final LongAdder high = new LongAdder();
            high.add(1);

            IntStream.range(0, numOfCycle).forEach(cycle -> {
                if (cycle % 2 == 0) {
                    high.add(high.longValue());
                } else {
                    high.add(1L);
                }
            });
            return high.longValue();
        }
    }

}
