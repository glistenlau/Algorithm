import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi on 4/10/15.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++){
            if (map.containsKey(target - numbers[i])){
                int[] result = new int[2];
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String args[]){
        TwoSum test = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] re = test.twoSum(numbers, target);
    }

}
