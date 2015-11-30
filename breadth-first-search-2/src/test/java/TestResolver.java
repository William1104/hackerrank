import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 11/27/2015.
 */

@RunWith(Parameterized.class)
public class TestResolver {

    @Parameterized.Parameter(value = 0)
    public int numOfNodes;

    @Parameterized.Parameter(value = 1)
    public int init;

    @Parameterized.Parameter(value = 2)
    public int[][] edges;

    @Parameterized.Parameter(value = 3)
    public int[] expectedOutput;


    @Parameterized.Parameters(name = "{index}: class-size: {0}, threshold:{1}, arrival-time:{2}, expected-result:{4}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{4, 0, new int[][]{{0, 1, 24}, {0, 3, 20}, {2, 0, 3}, {3, 2, 12}}, new int[]{24, 3, 15}});

    }


    @Test
    public void testResolve() {
        final int[] output = Solution.Resolver.resolve(numOfNodes, init, edges);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
