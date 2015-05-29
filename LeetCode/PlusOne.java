import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yi on 4/21/15.
 */
public class PlusOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PlusOne test = new PlusOne();
        int[] digits = {9, 9, 8, 9};
        int[] re = test.plusone(digits);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }
    }

    public int[] plusone(int[] digits) {
        int n = digits.length;
        if (n == 0)
            return digits;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] temp = Arrays.copyOf(digits, n + 1);
        temp[0] = 1;
        return temp;
    }
}
