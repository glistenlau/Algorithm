/**
 * 给一个字典,找出两个单词满足条件(1)没有相同的字母(2)长度的乘积最大.
 * 首先把字典里的所有单词所所有的字母用一个数字表示出来， 然后找出把没有相同字母的单词长度乘积最大。这样时间复杂度是O(kn + n^2), k是单词的平均长度。
 * 有一个可以稍微优化的方法，先对字典根据长度排序， 从长度大的开始遍历， 如果后面的乘积已经小于等于当前最大值， 就没必要继续比较了，不过这个最差情况的时间
 * 复杂度并没有改变。
 */
public class LongestUniqueWords {
  public int longestUniqueWords(String[] dict) {
    int[] hasAlpha = new int[dict.length];
    for (int i = 0; i < dict.length; i ++) {
      hasAlpha[i] = getInfo(dict[i]);
    }
    int max = 0;
    for (int i = 0; i < dict.length; i++) {
      for (int j = 0; j < dict.length; j++) {
        if ((hasAlpha[i] & hasAlpha[j]) == 0) {
          max = Math.max(max, dict[i].length() * dict[j].length());
        }
      }
    }

    return max;
  }

  private int getInfo(String s) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      ans |= (1 << (s.charAt(i) - 'a'));
    }

    return ans;
  }

  public static void main(String[] args) {
    String[] dict = {"abcd", "a", "abc", "bcd"};
    System.out.println(new LongestUniqueWords().longestUniqueWords(dict));
  }
}
