import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by william on 11/27/2015.
 */

@RunWith(Parameterized.class)
public class TestResolver {

    @Parameterized.Parameter(value = 0)
    public int input;
    @Parameterized.Parameter(value = 1)
    public BigInteger expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0} -> {1}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{25, new BigInteger("15511210043330985984000000")});
    }


    @Test
    public void testResolve() {
        final BigInteger output = Solution.Resolver.resolve(input);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
