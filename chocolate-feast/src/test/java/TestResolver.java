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
    public int money;

    @Parameterized.Parameter(value = 1)
    public int itemPrice;

    @Parameterized.Parameter(value = 2)
    public int exchangeRate;

    @Parameterized.Parameter(value = 3)
    public int expectedOutput;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{10, 2, 5, 6},
                new Object[]{12, 4, 4, 3},
                new Object[]{6, 2, 2, 5});
    }


    @Test
    public void testResolve() {
        final int result = Solution.Resolver.resolve(money, itemPrice, exchangeRate);
        Assert.assertThat(result, Matchers.equalTo(expectedOutput));
    }
}
