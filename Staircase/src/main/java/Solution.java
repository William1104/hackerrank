/**
 * Created by william on 11/27/2015.
 */
public class Solution {
    public static final class Resolver {
        public static String[] resolve(int size) {
            final String[] outputs = new String[size];
            for (int i = 0; i < size; i++) {
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size - (i + 1); j++) {
                    sb.append(' ');
                }
                for (int j = (size - (i + 1)); j < size; j++) {
                    sb.append('#');
                }
                outputs[i] = sb.toString();
            }

            return outputs;
        }
    }

}
