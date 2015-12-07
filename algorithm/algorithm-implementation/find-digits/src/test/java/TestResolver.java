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
    public long input;
    @Parameterized.Parameter(value = 1)
    public long expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{12, 2},
                new Object[]{1012, 3});
    }


    @Test
    public void testResolve() {
        final long output = Solution.Resolver.resolve(input);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
