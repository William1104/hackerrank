import java.util.Scanner;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String output = Resolver.resolve(scanner.nextLine());
            System.out.println(output);
        }
    }

    public static final class Resolver {
        public static String resolve(final String input) {

            final String filteredString = input.replaceAll(" ", "");

            final int length = filteredString.length();
            final int numCol = (int) Math.ceil(Math.sqrt(length));
            final int numRow = (int) Math.ceil(1.0 * length / numCol);

            final int newLength = length + numCol;
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numCol * (numRow + 1); i++) {
                int reindex = (i % (numRow + 1) * numCol) + i / (numRow + 1);
                if (reindex < length) {
                    sb.append(filteredString.charAt(reindex));
                } else {
                    sb.append(' ');
                }
            }
            return sb.toString().replaceAll("  ", " ").trim();
        }
    }

}

