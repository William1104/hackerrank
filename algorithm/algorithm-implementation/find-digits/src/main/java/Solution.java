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
                final long input = in.nextLong();
                        return String.valueOf(Resolver.resolve(input));
                    }
            ).forEach(System.out::println);
        }
    }

    public static final class Resolver {
        public static int resolve(long input) {

            final String inputStr = String.valueOf(input);
            return (int) IntStream.range(0, inputStr.length()).filter(i -> {
                final int digit = inputStr.charAt(i) - '0';
                return ((digit != 0) && (input % digit == 0));
            }).count();
        }
    }
}


