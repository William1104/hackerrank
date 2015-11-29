import java.util.Scanner;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int numChar = scanner.nextInt();
            String input = scanner.nextLine(); // read an empty line first.
            input = scanner.nextLine();

            int shift = scanner.nextInt();
            System.out.println(Resolver.resolve(input, shift));
        }
    }

    public static final class Resolver {
        public static String resolve(
                final String input,
                final int shift) {

            return input.codePoints()
                    .map(c -> {
                        if (c >= 'a' && c <= 'z') {
                            return (((c + shift) - 'a') % 26) + 'a';
                        } else if (c >= 'A' && c <= 'Z') {
                            return (((c + shift) - 'A') % 26) + 'A';
                        } else {
                            return c;
                        }
                    })
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
    }

}
