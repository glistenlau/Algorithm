public class Solution {
  /**
   * @param ratings Children's ratings
   * @return the minimum candies you must give
   */
  public int candy(int[] ratings) {
    int[] candyNum = new int[ratings.length];

    for (int i = 0; i < ratings.length; i++) {
      candyNum[i] = 1;
    }

    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candyNum[i] = candyNum[i - 1] + 1;
      }
    }

    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candyNum[i] = Math.max(candyNum[i], candyNum[i + 1] + 1);
      }
    }

    int sum = 0;
    for (int num: candyNum) {
      sum += num;
    }

    return sum;
  }
}
