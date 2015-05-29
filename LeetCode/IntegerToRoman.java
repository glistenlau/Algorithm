/**
 * Created by yi on 5/7/15.
 */
public class IntegerToRoman {
    private static final int[] values = {1, 5, 10, 50, 100, 500, 1000};
    private static final Character[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(45));
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 6; i >= 0; --i) {
            int n = num / values[i];
            for (int j = 0; j < n; ++j)
                result.append(romans[i]);
            num -= n * values[i];
            int validMinusIndex = 0;
            if (i > 4) validMinusIndex = 4;
            else if (i > 2) validMinusIndex = 2;
            else validMinusIndex = 0;
            if (i > 0 && values[i] / values[validMinusIndex] - num / values[validMinusIndex] == 1) {
                result.append(romans[validMinusIndex]);
                result.append(romans[i]);
                num -= (num / values[validMinusIndex]) * values[validMinusIndex];
            }
        }
        return result.toString();
    }
}
