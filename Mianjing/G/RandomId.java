/**
 * 给一组id和表示每个id出现概率的数组， 概率之和为1. 要求随机生成id， 使得随机出的id满足之前的概率数组。
 *
 * 思路是把概率加起来，然后生成一个随机数，看随机数在哪个区间里，根据输出id
 */
public class RandomId {
  private double[] prob;
  private int[] id;
  RandomId(int[] id, double[] prob) {
    this.prob = prob;
    this.id = id;
    for (int i = 1; i < prob.length; i++) {
      this.prob[i] += this.prob[i - 1];
    }
  }

  public int getRandomId() {
    return id[binarySearch(Math.random())];
  }

  private int binarySearch(double tar) {
    int left = 0;
    int right = prob.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (prob[mid] == tar) {
        return mid;
      } else if (prob[mid] < tar) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (tar <= prob[left]) {
      return left;
    }

    return right;
  }

  public static void main(String[] args) {
    int[] id = {0, 1, 2, 3, 4};
    double[] prob = {0.2, 0.2, 0.2, 0.2, 0.2};

    int[] count = new int[5];
    RandomId test = new RandomId(id, prob);
    for (int i = 0; i < 10000; i++) {
      count[test.getRandomId()]++;
    }

    for (int i = 0; i < 5; i++) {
      System.out.println("The id " + i + "'s probability is: " + (double)count[i] / 10000.0);
    }
  }

}
