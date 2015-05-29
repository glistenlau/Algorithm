/**
 * Created by YiLIU on 5/29/15.
 * The solution below is for the BadNeighbors problem in Topcoder:
 * http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 */
public class BadNeighbors {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        System.out.println(new BadNeighbors().maxDonations(test));
    }

    public int maxDonations(int[] donation) {
        int n = donation.length;
        int[] maxDonation = new int[n];
        //track the 0th donation.
        boolean[] zero_inclued = new boolean[n];
        //flag for the first and last residents touch.
        boolean last = false;
        //Initialization for the first resident.
        zero_inclued[0] = true;
        maxDonation[0] = donation[0];

        for (int i = 1; i < n; ++i) {
            maxDonation[i] = donation[i];
            zero_inclued[i] = false;
            for (int j = 0; j < i; ++j) {
                if (i == n - 1 && zero_inclued[j]) last = true;
                else last = false;
                if (!last && !isNeighbor(i, j, n) && maxDonation[j] +
                        donation[i] > maxDonation[i]) {
                    maxDonation[i] = maxDonation[j] + donation[i];
                    zero_inclued[i] = zero_inclued[j];
                } else if (last && !isNeighbor(i, j, n) && donation[i] >
                        donation[0]) {
                    maxDonation[i] = maxDonation[j] - donation[0] + donation[i];
                } else if (isNeighbor(i, j, n) && maxDonation[j] >
                        maxDonation[i]) {
                    maxDonation[i] = maxDonation[j];
                    zero_inclued[i] = zero_inclued[j];
                }
            }
        }

        return maxDonation[n - 1];
    }

    private boolean isNeighbor(int a, int b, int n) {
        return Math.abs(a - b) == 1 || (a == 0 && b == n - 1) ||
                (a == n - 1 && b == 0);
    }
}
