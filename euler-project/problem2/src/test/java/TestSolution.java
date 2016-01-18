import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

import static org.junit.runners.Parameterized.*;

/**
 * Created by williamwong on 17/1/2016.
 */

@RunWith(value = Parameterized.class)
public class TestSolution {

    @Parameter(0)
    public long input;

    @Parameter(1)
    public long expectedOutput;

    @Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{10, 10},
                new Object[]{100, 44}
        );
    }

    @Test
    public void test(){
        MatcherAssert.assertThat(Solution.solve(input), Matchers.equalTo(expectedOutput));

    }
}
