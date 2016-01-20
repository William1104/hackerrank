import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Created by williamwong on 17/1/2016.
 */

@RunWith(value = Parameterized.class)
public class TestSolution {

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expectedOutput;

    @Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{101110, 101101},
                new Object[]{800000, 793397}
        );
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.solve(input), Matchers.equalTo(expectedOutput));
    }
}
