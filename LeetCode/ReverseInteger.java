/**
 * Created by yi on 4/20/15.
 */
public class ReverseInteger {
    public int reverse(int num) {
        int rev = 0;
        int max = Integer.MAX_VALUE / 10;
        if (Math.abs(rev) > max)
            return 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        return rev;
    }
}
