import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            final int size = Integer.valueOf(in.nextLine());

            final String[] outputs = Resolver.resolve(size);

            Stream.of(outputs).forEach(System.out::println);
        }
    }

    public static final class Resolver {
        public static String[] resolve(int size) {
            final String[] outputs = new String[size];
            for (int i = 0; i < size; i++) {
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size - (i + 1); j++) {
                    sb.append(' ');
                }
                for (int j = (size - (i + 1)); j < size; j++) {
                    sb.append('#');
                }
                outputs[i] = sb.toString();
            }

            return outputs;
        }
    }

}
