/**
 * Created by root on 2/26/15.
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] temp = new int[N];
        int index = 0;
        k = k % N;
        for (int i = N - k; i < N; i++) {
            temp[index++] = nums[i];
        }
        for (int i = 0; i < N - k; i++) {
            temp[index++] = nums[i];
        }
        for (int i = 0; i < N; i++) {
            nums[i] = temp[i];
        }
    }
}
