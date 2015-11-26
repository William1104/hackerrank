import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.valueOf(in.nextLine());

            final int[] nums = Arrays
                    .stream(in.nextLine().split(" "))
                    .mapToInt(Integer::valueOf).toArray();

            final double[] outputs = Resolver.resolve(size, nums);
            final DecimalFormat df = new DecimalFormat("#.######");
            System.out.println(df.format(outputs[0]));
            System.out.println(df.format(outputs[1]));
            System.out.println(df.format(outputs[2]));
        }
    }

    public static final class Resolver {
        public static double[] resolve(int size, int[] nums) {

            final long positiveNum = IntStream.of(nums).filter(num -> num > 0).count();
            final long negativeNum = IntStream.of(nums).filter(num -> num < 0).count();
            final long zeoNum = IntStream.of(nums).filter(num -> num == 0).count();

            return new double[]{
                    1.0 * positiveNum / size,
                    1.0 * negativeNum / size,
                    1.0 * zeoNum / size
            };
        }
    }
}
