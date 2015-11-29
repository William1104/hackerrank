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
    public int[] input;
    @Parameterized.Parameter(value = 1)
    public int[] expectedOutput;

    @Parameterized.Parameters
    public static final Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{new int[]{5, 4, 4, 2, 2, 8}, new int[]{6, 4, 2, 1}},
                new Object[]{new int[]{1, 2, 3, 4, 3, 3, 2, 1}, new int[]{8, 6, 4, 1}});
    }

    @Test
    public void testResolve() {
        int[] output = Solution.Resolver.resolve(input);

        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}

