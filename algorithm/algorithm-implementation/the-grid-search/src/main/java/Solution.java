import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int numOfTest = scanner.nextInt();
            IntStream.range(0, numOfTest).mapToObj(testNum -> {
                final int gridNumOfRow = scanner.nextInt();
                scanner.nextLine(); // to consume the row for GridNumOfCol;
                final String[] grid = IntStream.range(0, gridNumOfRow).mapToObj(row -> scanner.nextLine()).toArray(String[]::new);

                final int patternNumOfRow = scanner.nextInt();
                scanner.nextLine(); // to consume the row for PatternNumOfCol;
                final String[] pattern = IntStream.range(0, patternNumOfRow).mapToObj(row -> scanner.nextLine()).toArray(String[]::new);

                return Resolver.resolve(pattern, grid);
            }).map(result -> result ? "YES" : "NO")
                    .forEach(System.out::println);
        }

    }

    public static final class Resolver {
        // return true if we can find the pattern in the grid.
        // return false if we cannot find the pattern in the grid.
        public static boolean resolve(String[] pattern, String[] grid) {

            int patternHeight = pattern.length;
            int patternWidth = pattern[0].length();
            int gridHeight = grid.length;
            int gridWidth = grid[0].length();

            return IntStream.rangeClosed(0, gridHeight - patternHeight).anyMatch(gridRow -> {
                return IntStream.rangeClosed(0, gridWidth - patternWidth).anyMatch(gridCol -> {
                    return IntStream.range(0, patternHeight).allMatch(patternRow -> {
                        String subRowInGrid = grid[(gridRow + patternRow)].substring(gridCol, gridCol + patternWidth);
                        String rowInPattern = pattern[patternRow];
                        return subRowInGrid.equals(rowInPattern);
                    });
                });
            });
        }
    }

}
