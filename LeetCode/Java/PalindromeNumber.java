import java.util.Scanner;

/**
 * Created by yi on 4/21/15.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PalindromeNumber test = new PalindromeNumber();
        int x = in.nextInt();
        System.out.println(test.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int div = 1;
        while (x / div >= 10)
            div *= 10;
        while (div != 0) {
            if (x / div != x % 10)
                return false;
            else {
                x = (x % div) / 10;
                div /= 100;
            }
        }
        return true;
    }
}
