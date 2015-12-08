import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/26/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int num = scanner.nextInt();
            final int[] sticks = IntStream.range(0, num).map(i -> scanner.nextInt()).toArray();
            IntStream.of(Resolver.resolve(sticks)).forEach(System.out::println);
        }
    }

    /**
     * Created by william on 11/27/2015.
     */
    public static final class Resolver {
        public static int[] resolve(int[] sticks) {
            final List<Integer> output = new LinkedList<>();

            int[] remainSticks = Arrays.copyOf(sticks, sticks.length);
            Arrays.sort(remainSticks);

            while (remainSticks.length > 0) {
                output.add(remainSticks.length);
                int cut = remainSticks[0];

                remainSticks = IntStream
                        .of(remainSticks)
                        .map(s -> s - cut)
                        .filter(s -> s > 0)
                        .toArray();
            }

            return output.stream().mapToInt(i -> i).toArray();
        }
    }


}
