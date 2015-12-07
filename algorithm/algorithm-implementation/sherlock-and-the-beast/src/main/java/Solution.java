import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner in = new Scanner(System.in)) {
            final int numOfTest = in.nextInt();

            IntStream.range(0, numOfTest).mapToObj(testNumber -> {
                final int size = in.nextInt();
                final int[] output = Resolver.resolve(size);

                final StringBuilder outputStr = new StringBuilder();
                for (int i = 0; i < output.length; i++) {
                    outputStr.append(String.valueOf(output[i]));
                }
                return outputStr.toString();
            }).forEach(System.out::println);
        }

    }

    public static final class Resolver {
        public static int[] resolve(int size) {
            OptionalInt boundaryIndex = IntStream
                    .rangeClosed(0, size)
                    .map(i -> size - i)
                    .filter(numberOfFives -> {

                        int numberOfThrees = size - numberOfFives;

                        boolean divisibleByThree = (numberOfFives % 3 == 0);
                        boolean divisibleByFive = (numberOfThrees % 5 == 0);

                        return divisibleByFive && divisibleByThree;
                    })
                    .findAny();

            if (boundaryIndex.isPresent()) {
                final int[] output = new int[size];
                Arrays.fill(output, 0, boundaryIndex.getAsInt(), 5);
                Arrays.fill(output, boundaryIndex.getAsInt(), size, 3);
                return output;
            } else {
                return new int[]{-1};
            }
        }
    }
}
