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
    public String input;
    @Parameterized.Parameter(value = 1)
    public String expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{"07:05:45PM", "19:05:45"},
                new Object[]{"07:05:45AM", "07:05:45"},
                new Object[]{"12:00:00AM", "00:00:00"},
                new Object[]{"12:00:00PM", "12:00:00"});
    }

    @Test
    public void testResolve() {
        final String output = Solution.Resolver.resolve(input);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
