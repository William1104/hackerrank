import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/8/2015.
 */
@RunWith(value = Parameterized.class)
public class TestSolution {

    @Parameterized.Parameter(value = 0)
    public int numOfRow;

    @Parameterized.Parameter(value = 1)
    public int numOfCol;


    @Parameterized.Parameter(value = 2)
    public int step;


    @Parameterized.Parameter(value = 3)
    public int[][] matrix;


    @Parameterized.Parameter(value = 4)
    public int[][] expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0},{1},{2},{3}->{4}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{4, 4, 1,
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        new int[][]{{2, 3, 4, 8}, {1, 7, 11, 12}, {5, 6, 10, 16}, {9, 13, 14, 15}}},
                new Object[]{4, 4, 2,
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                        new int[][]{{3, 4, 8, 12}, {2, 11, 10, 16}, {1, 7, 6, 15}, {5, 9, 13, 14}}},
                new Object[]{5, 4, 7,
                        new int[][]{{1, 2, 3, 4}, {7, 8, 9, 10}, {13, 14, 15, 16}, {19, 20, 21, 22}, {25, 26, 27, 28}},
                        new int[][]{{28, 27, 26, 25}, {22, 9, 15, 19}, {16, 8, 21, 13}, {10, 14, 20, 7}, {4, 3, 2, 1}}},
                new Object[]{2, 2, 3, new int[][]{{1, 1}, {1, 1}}, new int[][]{{1, 1}, {1, 1}}});
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.Resolver.resolve(numOfRow, numOfCol, step, matrix),
                Matchers.equalTo(expectedOutput));
    }

}
