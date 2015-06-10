/**
 * Created by YiLIU on 6/9/15.
 */
public class SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while(left < right) {
      int mid = (left) / 2 + right / 2;
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] > target)
        right = mid;
      else
        left = mid + 1;
    }
    return left = nums[left] < target ? left + 1 : left;
  }

  public static void main(String[] args) {
    int[] test = {1, 3, 5, 6};
    System.out.println(new SearchInsertPosition().searchInsert(test, 7));
  }
}
