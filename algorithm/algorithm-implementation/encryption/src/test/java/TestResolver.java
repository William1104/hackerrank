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
                new Object[]{"if man was meant to stay on the ground god would have given us roots", "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"},
                new Object[]{"haveaniceday", "hae and via ecy"},
                new Object[]{"feedthedog", "fto ehg ee dd"},
                new Object[]{"chillout", "clu hlt io"},
                new Object[]{"roqfqeylxuyxjfyqterizzkhgvngapvudnztsxeprfp", "rlyzatp oxqkps quthvx fyegue qxrvdp ejinnr yfzgzf"});
    }


    @Test
    public void testResolve() {
        final String output = Solution.Resolver.resolve(input);
        Assert.assertThat(output, Matchers.equalTo(expectedOutput));
    }
}
