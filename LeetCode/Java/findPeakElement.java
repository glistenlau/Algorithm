/**
 * Created by yiliu on 3/6/15.
 */
public class findPeakElement {

    public int findPeakElement(int[] num) {
        int l = 0;
        int r = num.length - 1;
        int mid = r / 2;
        while (l < r) {
            if (num[mid] < num[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return l;
    }
}
