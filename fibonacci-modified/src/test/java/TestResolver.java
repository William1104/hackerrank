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
    public int a;

    @Parameterized.Parameter(value = 1)
    public int b;

    @Parameterized.Parameter(value = 2)
    public int n;

    @Parameterized.Parameter(value = 3)
    public BigInteger expectedOutput;

    @Parameterized.Parameters(name = "{index}: {0}, {1}, {2} -> {3}")
    public static Iterable<Object[]> data() {
        return Arrays.<Object[]>asList(
                new Object[]{0, 1, 5, BigInteger.valueOf(5)},
                new Object[]{0, 1, 10, new BigInteger("84266613096281243382112")});
    }


    @Test
    public void testResolve() {
        final BigInteger output = Solution.Resolver.resolve(a, b, n);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
