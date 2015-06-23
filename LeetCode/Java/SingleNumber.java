import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi on 5/5/15.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!lookup.containsKey(nums[i])) {
                lookup.put(nums[i], 1);
            } else
                lookup.replace(nums[i], 2);
        }

        for (Map.Entry<Integer, Integer> e : lookup.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();
        }

        return -1;
    }
}
