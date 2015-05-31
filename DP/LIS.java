import java.util.Scanner;

/**
 * Created by Yi on 5/27/2015.
 */
public class LIS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] test = new int[n];
        for (int i = 0; i < n; ++i) {
            test[i] = in.nextInt();
        }
        System.out.println(new LIS().solution(test));
    }

    public int solution(int[] nums) {
        int[] temp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            temp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && temp[j] + 1 > temp[i]) {
                    temp[i] = temp[j] + 1;
                }
            }
            max = Math.max(max, temp[i]);
        }
        return max;
    }
}
