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
    public int insertNum;

    @Parameterized.Parameter(value = 1)
    public int[] nums;

    @Parameterized.Parameter(value = 2)
    public long expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0}, {1} -> {2}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{4, new int[]{1, 4, 5, 7, 9, 12}, 1});
    }


    @Test
    public void testResolve() {
        final long output = Solution.Resolver.resolve(insertNum, nums);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
