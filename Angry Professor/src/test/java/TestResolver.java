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
    public int classSize;

    @Parameterized.Parameter(value = 1)
    public int threshold;

    @Parameterized.Parameter(value = 2)
    public int[] arrivalTimes;

    @Parameterized.Parameter(value = 3)
    public boolean expectedOutput;

    @Parameterized.Parameters(name = "{index}: class-size: {0}, threshold:{1}, arrival-time:{2}, expected-result:{4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{4, 1, new int[]{-1, -1, -1, -1}, false},
                new Object[]{4, 2, new int[]{-1, -1, -1, -1}, false},
                new Object[]{4, 4, new int[]{-1, -1, -1, -1}, false},
                new Object[]{4, 1, new int[]{0, 0, 0, 0}, false},
                new Object[]{4, 2, new int[]{0, 0, 0, 0}, false},
                new Object[]{4, 4, new int[]{0, 0, 0, 0}, false},
                new Object[]{4, 1, new int[]{1, 1, 1, 1}, true},
                new Object[]{4, 2, new int[]{1, 1, 1, 1}, true},
                new Object[]{4, 4, new int[]{1, 1, 1, 1}, true},
                new Object[]{4, 1, new int[]{-1, -3, 4, 2}, false},
                new Object[]{4, 2, new int[]{-1, -3, 4, 2}, false},
                new Object[]{4, 4, new int[]{-1, -3, 4, 2}, true},
                new Object[]{4, 1, new int[]{0, -1, 2, 1}, false},
                new Object[]{4, 2, new int[]{0, -1, 2, 1}, false},
                new Object[]{4, 4, new int[]{0, -1, 2, 1}, true});
    }


    @Test
    public void testResolve() {
        final boolean result = Solution.Resolver.shouldClassBeCancelled(classSize, threshold, arrivalTimes);
        Assert.assertThat(result, Matchers.equalTo(expectedOutput));
    }
}
