import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static final class Resolver {
        public static double[] resolve(int size, int[] nums) {

            long positiveNum = IntStream.of(nums).filter(num -> num > 0).count();
            long negativeNum = IntStream.of(nums).filter(num -> num < 0).count();
            long zeoNum = IntStream.of(nums).filter(num -> num == 0).count();

            return new double[]{
                    1.0 * positiveNum / size,
                    1.0 * negativeNum / size,
                    1.0 * zeoNum / size
            };
        }
    }
}
