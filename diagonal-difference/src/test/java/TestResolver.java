import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by william on 11/27/2015.
 */
public class TestResolver {

    @Test
    public void testResolve() {
        int size = 3;
        int nums[][] = new int[][]{
                new int[]{11, 2, 4},
                new int[]{4, 5, 6},
                new int[]{10, 8, -12}
        };

        int output = Solution.Resolver.resolve(size, nums);

        Assert.assertThat(output, CoreMatchers.equalTo(15));
    }
}

