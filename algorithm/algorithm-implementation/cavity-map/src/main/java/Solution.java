import java.util.Scanner;

/**
 * Created by william on 12/9/2015.
 */
public class Solution {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int n = scanner.nextInt();
            scanner.nextLine();
            final int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt("" + line.charAt(j));
                }
            }

            final int[][] output = Resolver.resolve(map);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cell = output[i][j];
                    if (cell > 0) {
                        System.out.print(cell);
                    } else {
                        System.out.print('X');
                    }
                }
                System.out.println();
            }
        }
    }

    public static final class Resolver {
        public static int[][] resolve(int[][] map) {
            final int height = map.length;
            final int[][] output = new int[height][height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < height; j++) {
                    if (i != 0 && i != height - 1 &&
                            j != 0 && j != height - 1 &&
                            map[i - 1][j] < map[i][j] &&
                            map[i][j - 1] < map[i][j] &&
                            map[i + 1][j] < map[i][j] &&
                            map[i][j + 1] < map[i][j]) {
                        output[i][j] = -1;
                    } else {
                        output[i][j] = map[i][j];
                    }
                }
            }

            return output;
        }
    }

}
