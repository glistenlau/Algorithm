import java.util.Stack;

/**
 * Created by Yi on 5/28/2015.
 */
public class ZigZag {
    public static void main(String[] args) {
        int[] nums = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
        System.out.println(new ZigZag().longgestZigZag(nums));
    }

    public int longgestZigZag(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] longest = new int[n];
        int[] lastValue = new int[n];

        longest[0] = 1;

        for (int i = 1; i < n; ++i) {
            longest[i] = 1;
            for (int j = 0; j < i; ++j) {
                int diff = compare(nums[j], nums[i]);
                if (diff != 0 && diff != lastValue[j] && longest[j] + 1 > longest[i]) {
                    longest[i] = longest[j] + 1;
                    lastValue[i] = diff;
                }
            }
        }

        return longest[n - 1];
    }

    private int compare(int a, int b) {
        if (a < b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}
