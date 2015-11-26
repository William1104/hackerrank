import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/26/2015.
 */
public class Solution {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int size = Integer.valueOf(in.nextLine());

            int[][] nums = new int[size][];

            for (int i = 0; i < size; i++) {
                nums[i] = Arrays.stream(in.nextLine().split(" "))
                        .mapToInt(Integer::valueOf).toArray();
            }

            System.out.println(Resolver.resolve(size, nums));
        }
    }

    /**
     * Created by william on 11/27/2015.
     */
    public static final class Resolver {
        public static int resolve(int size, int[][] nums) {
            int primaryDiagonal = IntStream
                    .range(0, size)
                    .reduce(0, (sum, index) -> sum += nums[index][index]);

            int secondaryDiagonal = IntStream
                    .range(0, size)
                    .reduce(0, (sum, index) -> sum += nums[size - index - 1][index]);
            int diff = primaryDiagonal - secondaryDiagonal;
            return diff > 0 ? diff : -diff;
        }
    }


}
