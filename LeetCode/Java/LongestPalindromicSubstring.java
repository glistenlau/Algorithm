import java.util.Scanner;

/**
 * Created by Yi on 4/17/2015.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = midExpand(s, i, i);
            int len2 = midExpand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int midExpand(String s, int start, int end) {
        int L = start; int R = end;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        String s = in.nextLine();
        System.out.println(test.longestPalindrome(s));
    }
}
