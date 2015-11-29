import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int numberOfClass = in.nextInt();

            IntStream.range(0, numberOfClass).mapToObj(classNumber -> {
                final int numberOfStudent = in.nextInt();
                final int threshold = in.nextInt();
                final int[] arrivalTimes = IntStream
                        .range(0, numberOfStudent)
                        .map(studentNumber -> in.nextInt())
                        .toArray();

                return Resolver.shouldClassBeCancelled(
                        numberOfStudent,
                        threshold,
                        arrivalTimes);
            }).forEachOrdered(shouldClassBeCancelled -> System.out.println(shouldClassBeCancelled ? "YES" : "NO"));
        }
    }

    public static final class Resolver {
        public static boolean shouldClassBeCancelled(
                final int numberOfStudent,
                final int threshold,
                final int[] arrivalTimes) {

            final int numOnTimeStudents = (int) IntStream.of(arrivalTimes).filter(t -> t <= 0).count();

            return numOnTimeStudents < threshold;

        }
    }

}
