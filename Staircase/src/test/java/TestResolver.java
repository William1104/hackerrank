import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by william on 11/27/2015.
 */
public class TestResolver {

    @Test
    public void testResolve() {

        final int size = 6;
        final String[] outputs = Solution.Resolver.resolve(size);

        Assert.assertThat(outputs, Matchers.equalTo(new String[]{
                "     #",
                "    ##",
                "   ###",
                "  ####",
                " #####",
                "######"}));
    }
}
