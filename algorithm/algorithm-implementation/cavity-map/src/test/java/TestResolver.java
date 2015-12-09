import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/9/2015.
 */
@RunWith(value = Parameterized.class)
public class TestResolver {

    @Parameterized.Parameter(0)
    public int[][] map;

    @Parameterized.Parameter(1)
    public int[][] expectedOutput;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{
                        new int[][]{{1, 1, 1, 2}, {1, 9, 1, 2}, {1, 8, 9, 2}, {1, 2, 3, 4}},
                        new int[][]{{1, 1, 1, 2}, {1, -1, 1, 2}, {1, 8, -1, 2}, {1, 2, 3, 4}}});
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.Resolver.resolve(map), Matchers.equalTo(expectedOutput));
    }
}
