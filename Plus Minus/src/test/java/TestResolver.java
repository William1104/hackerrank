import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by william on 11/27/2015.
 */
public class TestResolver {

    @Test
    public void testResolve() {

        int size = 3;
        int nums[] = new int[]{-4, 3, 9, 0, 4, 1};

        double[] outputs = Solution.Resolver.resolve(size, nums);

        Assert.assertThat(outputs[0], Matchers.closeTo(0.500000, 10e-4));
        Assert.assertThat(outputs[1], Matchers.closeTo(0.333333, 10e-4));
        Assert.assertThat(outputs[2], Matchers.closeTo(0.166667, 10e-4));
    }
}
