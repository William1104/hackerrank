import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/10/2015.
 */

@RunWith(Parameterized.class)
public class TestResolver {

    @Parameterized.Parameter(0)
    public int n;

    @Parameterized.Parameter(1)
    public int a;

    @Parameterized.Parameter(2)
    public int b;

    @Parameterized.Parameter(3)
    public int[] expectedOutput;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{3, 1, 2, new int[]{2, 3, 4}},
                new Object[]{4, 10, 100, new int[]{30, 120, 210, 300}});

    }

    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.Resolver.resolve(n, a, b), Matchers.equalTo(expectedOutput));
    }


}
