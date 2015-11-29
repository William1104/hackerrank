import java.util.Arrays;

/**
 * Created by william on 11/27/2015.
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static final class Resolver {
        private final int lengthOfFreeway;
        private final int[] width;

        public Resolver(final int lengthOfFreeway, final int[] width) {
            super();
            this.lengthOfFreeway = lengthOfFreeway;
            this.width = Arrays.copyOf(width, lengthOfFreeway);
        }

        public int resolve(int start, int end) {
            int max = width[start];
            for (int i = start + 1; i < end; i++) {
                max = Math.min(max, width[i]);
            }
            return max;
        }
    }
}
