import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/3/2015.
 */

@RunWith(Parameterized.class)
public class TestResolver {
    @Parameterized.Parameter(0)
    public int numOfNode;

    @Parameterized.Parameter(1)
    public int initIndex;

    @Parameterized.Parameter(2)
    public int[][] edges;

    @Parameterized.Parameter(3)
    public int expectedOutput;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{4, 1, new int[][]{{1, 2, 5}, {1, 3, 3}, {4, 1, 6}, {2, 4, 7}, {3, 2, 4}, {3, 4, 5}}, 12});
    }

    @Test
    public void testResolv() {
        final int output = Solution.Resolver.resolve(numOfNode, initIndex, edges);
        MatcherAssert.assertThat(output, Matchers.equalTo(expectedOutput));
    }


}
