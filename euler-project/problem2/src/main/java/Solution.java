import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

/**
 * Created by williamwong on 17/1/2016.
 */
public final class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int t = scanner.nextInt();
            IntStream.rangeClosed(1, t).mapToLong(testNum -> {
                final long n = scanner.nextLong();
                return solve(n);
            }).forEach(System.out::println);
        }
    }

    public static long solve(long n) {
        LongStream fibStream = StreamSupport
                .longStream(Spliterators.spliteratorUnknownSize(
                        new FibonacciGenerator(i -> i <= n),
                        Spliterator.ORDERED),
                        false);

        return fibStream.filter(i-> i%2==0).sum();
    }
}


class FibonacciGenerator implements PrimitiveIterator.OfLong {
    private final LongPredicate predicate;
    private long n_2 = 0;
    private long n_1 = 1;

    protected FibonacciGenerator(final LongPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        return predicate.test(n_1 + n_2);
    }

    @Override
    public long nextLong() {
        long fib = n_2 + n_1; // cal fib by adding n_2 and n_1
        n_2 = n_1;           // shift n_1 to n_2
        n_1 = fib;           // shift fib to n_1
        return fib;
    }
}