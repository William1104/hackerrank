import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final String inputTime = in.nextLine();

            final String outputTime = Resolver.resolve(inputTime);

            System.out.println(outputTime);
        }
    }

    public static final class Resolver {
        private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
        private static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        public static String resolve(String input) {

            final LocalTime localTime = LocalTime.parse(input, inputFormat);
            return localTime.format(outputFormat);
        }
    }

}
