import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/9/2015.
 */

@RunWith(value = Parameterized.class)
public class TestResolver {

    @Parameterized.Parameter(0)
    public int hour;

    @Parameterized.Parameter(1)
    public int minute;

    @Parameterized.Parameter(2)
    public String expectedOutput;

    @Parameterized.Parameters(name = "{index}:{0},{1}->{2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{5, 0, "five o' clock"},
                new Object[]{5, 1, "one minute past five"},
                new Object[]{5, 10, "ten minutes past five"},
                new Object[]{5, 30, "half past five"},
                new Object[]{5, 40, "twenty minutes to six"},
                new Object[]{5, 45, "quarter to six"},
                new Object[]{5, 47, "thirteen minutes to six"},
                new Object[]{5, 28, "twenty eight minutes past five"});
    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.Resolver.resolve(hour, minute), Matchers.equalTo(expectedOutput));
    }
}
