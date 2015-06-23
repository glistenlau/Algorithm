import java.util.Arrays;
import java.util.List;

/**
 * Created by yi on 5/7/15.
 */
public class RomanToInteger {
    private static final int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final List<String> romansList = Arrays.asList(romans);

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("IX"));
    }

    public int romanToInt(String s) {
        int n = s.length();
        int result = 0;
        int i = 0;
        while (i < n) {
            if (i < n - 1 && romansList.contains(s.substring(i, i + 2))) {
                result += values[romansList.indexOf(s.substring(i, i + 2))];
                i += 2;
            } else {
                result += values[romansList.indexOf(s.substring(i, i + 1))];
                i += 1;
            }
        }
        return result;
    }
}
