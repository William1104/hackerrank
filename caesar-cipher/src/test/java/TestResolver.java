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
    public int shift;

    @Parameterized.Parameter(value = 2)
    public String expectedOutput;

    @Parameterized.Parameters(name = "{index}: input: {0}, shift:{1}, expected-output:{2}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(new Object[]{"middle-Outz", 2, "okffng-Qwvb"});
    }


    @Test
    public void testResolve() {
        final String output = Solution.Resolver.resolve(input, shift);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
