import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yi on 4/15/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] charmap = new int[256];
        Arrays.fill(charmap, -1);
        int i = 0;
        int maxl = 0;
        for(int j = 0; j < s.length(); j++) {
            if(charmap[s.charAt(j)] >= i)
                i = charmap[s.charAt(j)] + 1;
            charmap[s.charAt(j)] = j;
            maxl = Math.max(maxl, j - i + 1);
        }
        return maxl;
    }
}
