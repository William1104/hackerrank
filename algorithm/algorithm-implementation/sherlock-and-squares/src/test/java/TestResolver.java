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
    public long lowerBound;

    @Parameterized.Parameter(value = 1)
    public long upperBound;

    @Parameterized.Parameter(value = 2)
    public int expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0}, {1} -> {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{3, 9, 2},
                new Object[]{17, 24, 0});
    }

    @Test
    public void testResolve() {
        final int output = Solution.Resolver.resolve(lowerBound, upperBound);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
