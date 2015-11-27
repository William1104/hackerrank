import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 11/27/2015.
 */
public class TestResolver {

    @Parameterized.Parameter(value = 0)
    public int size;
    @Parameterized.Parameter(value = 1)
    public int[] expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{1, new int[]{-1}},
                new Object[]{3, new int[]{5, 5, 5}},
                new Object[]{5, new int[]{3, 3, 3, 3, 3}},
                new Object[]{11, new int[]{5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3}});
    }

    @Test
    public void testResolve() {
        final int[] output = Solution.Resolver.resolve(size);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
