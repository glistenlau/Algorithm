import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yi on 4/15/15.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int length(String s) {
        List<Character> currentChars = new ArrayList<Character>();
        int count = 0;
        int j = 0;
        int maxl = 0;
        for(int i = 0; i <s.length(); i++) {
            if(!currentChars.contains(s.charAt(i))) {
                count += 1;
                currentChars.add(s.charAt(i));
            }

            if(count > 2){
                count = 0;
                j = i;
                currentChars.clear();
            }

            maxl = Math.max(maxl, i - j + 1);
        }
        return maxl;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
        String s = in.nextLine();
        System.out.println(test.length(s));
    }
}
