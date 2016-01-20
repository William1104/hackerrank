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

    // if start < end, step should be positive
    // if start = end, step can be anything.
    // if start > end,  step should be negative
    static IntStream rangeInclusive(int start, int end, int step) {
        if (start == end){
            return IntStream.rangeClosed(start, end);
        }

        if (step == 0){
            throw new IllegalArgumentException("if start != end, step cannot be zero");
        }


        int nStep = (end - start)/step;
        if ( nStep < 0 ){
            throw new IllegalArgumentException("if start < end, step should be positive. if start > end, step should be negative");
        }

        return IntStream.rangeClosed(0, nStep)
                .map(i -> i * step)
                .map(i -> i + start);
    }

    public static int solve(long n) {
        return rangeInclusive(999,100,-1)
                .mapToObj(i -> rangeInclusive(999,i, -1)
                        // since n must be palindrome
                        // n = 100000x + 10000y + 1000z + 100z + 10y + 1x
                        // n = 100001x + 10010y + 1100z
                        // n = 11(9091x + 910y + 100z)
                        // therefore, n must be divisible by 11
                        // and either i or j much be divisible by 11
                        .filter(j -> (j%11==0) || (i%11==0))
                        .map(j -> i * j)

                        // we are search number below n
                        .filter(j -> j <=n)

                        // check if the number is palindrome
                        .filter(Solution::isPalindrome)

                        // j stream is straightly decreasing
                        // therefore, the first one matched should be the greatest number of given i.
                        .findFirst()
                        )
                .filter(i -> i.isPresent())
                .mapToInt(i -> i.getAsInt())
                .max()
                .getAsInt();

    }

    public static boolean isPalindrome(long n) {
        final StringBuilder sb = new StringBuilder(Long.toString(n));
        final int len = sb.length();
        return IntStream.rangeClosed(0, len / 2).allMatch(i -> sb.charAt(i) == sb.charAt(len - i - 1));
    }
}