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
    public Solution.Resolver resolver;

    @Parameterized.Parameter(value = 1)
    public int start;

    @Parameterized.Parameter(value = 2)
    public int end;

    @Parameterized.Parameter(value = 3)
    public int expectedOutput;

    @Parameterized.Parameters(name = "{index}: start[{1}], end[{2}] -> result[{3}]")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{new Solution.Resolver(8, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), 0, 3, 1},
                new Object[]{new Solution.Resolver(8, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), 4, 6, 2},
                new Object[]{new Solution.Resolver(8, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), 6, 7, 3},
                new Object[]{new Solution.Resolver(8, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), 3, 5, 2},
                new Object[]{new Solution.Resolver(8, new int[]{2, 3, 1, 2, 3, 2, 3, 3}), 0, 7, 1});
    }

    @Test
    public void testResolve() {
        final int output = resolver.resolve(start, end);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
