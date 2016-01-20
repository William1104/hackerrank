import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Created by williamwong on 17/1/2016.
 */

@RunWith(value = Parameterized.class)
public class TestRangeFunction {

    @Parameter(0)
    public int start;


    @Parameter(1)
    public int end;

    @Parameter(2)
    public int step;

    @Parameter(3)
    public int[] expectedOutput;

    @Parameters(name = "{index}: {0},{1},{2}->{3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{0,0,0, new int[]{0}},
                new Object[]{0,0,1, new int[]{0}},
                new Object[]{0,0,-1, new int[]{0}},
                new Object[]{0,5,1, new int[]{0,1,2,3,4,5}},
                new Object[]{0,5,2, new int[]{0,2,4}},
                new Object[]{1,5,1, new int[]{1,2,3,4,5}},
                new Object[]{1,5,2, new int[]{1,3,5}},
                new Object[]{5,1,-1, new int[]{5,4,3,2,1}},
                new Object[]{5,1,-2, new int[]{5,3,1}},
                new Object[]{5,1,-2, new int[]{5,3,1}},
                new Object[]{-5,5,3, new int[]{-5,-2,1,4}}
                );
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.rangeInclusive(start,end,step).toArray(), Matchers.equalTo(expectedOutput));
    }
}
