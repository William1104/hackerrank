import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by william on 12/8/2015.
 */
public class Solution {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int numOfRow = scanner.nextInt();
            final int numOfCol = scanner.nextInt();
            final int numOfStep = scanner.nextInt();

            final int[][] matrix = IntStream.range(0, numOfRow).mapToObj(row ->
                    IntStream.range(0, numOfCol).map(col -> scanner.nextInt()).toArray()
            ).toArray(int[][]::new);

            final int[][] output = Resolver.resolve(numOfRow, numOfCol, numOfStep, matrix);
            for (int i = 0; i < numOfRow; i++) {
                for (int j = 0; j < numOfCol; j++) {
                    System.out.print(output[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static final class Point {
        int row;
        int col;
        int val;

        public Point(int r, int c, int v) {
            super();
            this.row = r;
            this.col = c;
            this.val = v;
        }

    }

    public static final class Resolver {
        public static int[][] resolve(int numOfRow, int numOfCol, int step, int[][] matrix) {
            int numOfLevel = Math.min(numOfRow, numOfCol) / 2;
            int[][] output = new int[numOfRow][numOfCol];
            IntStream.range(0, numOfLevel).mapToObj(level -> {
                int top = (numOfRow - 1) - level;
                int button = level;
                int left = level;
                int right = (numOfCol - 1) - level;

                return Stream.concat(
                        Stream.<Point>concat(
                                IntStream.range(left, right).mapToObj(col -> new Point(button, col, matrix[button][col])),
                                IntStream.range(button, top).mapToObj(row -> new Point(row, right, matrix[row][right]))),
                        Stream.<Point>concat(
                                IntStream.range(left, right).mapToObj(col -> new Point(top, (numOfCol - 1 - col), matrix[top][numOfCol - 1 - col])),
                                IntStream.range(button, top).mapToObj(row -> new Point((numOfRow - 1 - row), left, matrix[numOfRow - 1 - row][left]))))
                        .toArray(Point[]::new);
            }).forEach(ring -> {
                for (int i = 0; i < ring.length; i++) {
                    final Point point = ring[i];
                    output[point.row][point.col] = ring[(i + step) % ring.length].val;
                }
            });

            return output;
        }
    }
}
