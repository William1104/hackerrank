import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by william on 12/9/2015.
 */

@RunWith(value = Parameterized.class)
public class TestResolver {


    @Parameterized.Parameter(0)
    public String[] grid;

    @Parameterized.Parameter(1)
    public String[] pattern;


    @Parameterized.Parameter(2)
    public boolean expectedOutput;

    @Parameterized.Parameters(name = "{index}:{0},{1}->{2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(
                new Object[]{new String[]{"1234567890", "0987654321", "1111111111", "1111111111", "2222222222"},
                        new String[]{"876543", "111111", "111111"}, true},
                new Object[]{new String[]{"7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"},
                        new String[]{"9505", "3845", "3530"}, true},
                new Object[]{new String[]{"400453592126560", "114213133098692", "474386082879648", "522356951189169", "887109450487496", "252802633388782", "502771484966748", "075975207693780", "511799789562806", "404007454272504", "549043809916080", "962410809534811", "445893523733475", "768705303214174", "650629270887160"},
                        new String[]{"99", "99"}, false});
    }
    
    @Test
    public void test() {
        MatcherAssert.assertThat(Solution.Resolver.resolve(pattern, grid), Matchers.equalTo(expectedOutput));
    }
}
