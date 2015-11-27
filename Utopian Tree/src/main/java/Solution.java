import java.util.Scanner;
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
            ).forEach(System.out::print);
        }
    }

    public static final class Resolver {
        public static int resolve(int input) {
            throw new UnsupportedOperationException();
        }
    }

}
