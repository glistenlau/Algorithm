import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yi on 4/15/15.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
        String s = in.nextLine();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1;
        int maxl = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(k) != s.charAt(j)) {
                maxl = Math.max(maxl, k - i);
                i = j + 1;
            }
            j = k - 1;
        }
        return maxl;
    }
}
