import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
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
        // STEP - 1
        // if N is even, keep divide it with 2.
        long remain = divide(n, 2);

        // STEP - 2
        // if remain becomes 1,
        // return 2 which is the biggest prime factor
        if (remain == 1) {
            return 2;
        }

        // STEP - 3
        // start with factor=3 and check if the remain is divisible by factor.
        // increment factor by 2.
        // run the loop till square root of the N.

        long factor = 1;
        do {
            factor += 2;
            remain = divide(remain, factor);
        } while (remain > 1 && factor <= Math.sqrt(remain));

        if (remain == 1){
            return factor;
        } else {
            return remain;
        }
    }

    public static long divide(long n, long factor){
        long remain = n;
        while (remain % factor == 0){
            remain /= factor;
        }
        return remain;
    }
}