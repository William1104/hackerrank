import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int insertNum = scanner.nextInt();
            int size = scanner.nextInt();
            System.out.println(Resolver.resolve(insertNum, IntStream.range(0, size).map(i -> scanner.nextInt()).toArray()));
        }
    }

    public static final class Resolver {
        public static int resolve(int insertNum, int[] nums) {
            return (int) IntStream.of(nums).filter(i -> i < insertNum).count();
        }
    }
}


