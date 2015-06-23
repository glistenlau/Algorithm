import java.util.Scanner;

/**
 * Created by yi on 4/15/15.
 */
public class LongestSubstringWithAtMostKDistinctCharactors {
    public int lengthOfLongestSubstringWithKDistinct(String s, int k) {
        int[] count = new int[256];
        int numCount = 0;
        int i = 0;
        int maxL = 0;
        for(int j = 0; j < s.length(); j++) {
            if(count[s.charAt(j)] == 0) {
                numCount += 1;
            }
            count[s.charAt(j)] += 1;
            while(numCount > k) {
                count[s.charAt(i)] -= 1;
                maxL = Math.max(maxL, j - i);
                if(count[s.charAt(i)] == 0)
                    numCount -= 1;
                i += 1;
            }

        }
        return Math.max(maxL, s.length() - i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LongestSubstringWithAtMostKDistinctCharactors test = new LongestSubstringWithAtMostKDistinctCharactors();
        String s = in.nextLine();
        int k = in.nextInt();
        System.out.println(test.lengthOfLongestSubstringWithKDistinct(s, k));
    }
}
