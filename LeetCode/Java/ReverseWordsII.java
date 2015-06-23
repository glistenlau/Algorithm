import java.util.Scanner;

/**
 * Created by yi on 4/13/15.
 */
public class ReverseWordsII {
    public void ReverseWordsII(char[] s) {
        int mark = 0;
        reverse(s, 0, s.length);
        for(int i = 0; i < s.length + 1; i++){
            if(i == s.length || s[i] == ' '){
                reverse(s, mark, i);
                mark = i + 1;
            }
        }
    }

    private void reverse(char[] s, int start, int end){
        end = end - 1;
        while(start < end) {
            char temp;
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ReverseWordsII test = new ReverseWordsII();
        String s = in.nextLine();
        char[] c = s.toCharArray();
        test.ReverseWordsII(c);
        System.out.println(c);
    }
}
