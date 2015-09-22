import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two string S and T with same length, the distance is defined as the number of positions in which S
 * and T have different characters. Your task is to minimize this distance, by swap at most 2 characters
 * (which means at most 1 swap) in S. Return the two index. If it is not necessary to swap, return -1, -1.
 * Both S and T contain only lowercase alphabets. If there is multiple solutions, return anyone.
 *
 *
 * The idea is when we find a position, two characters for two strings are different, first we
 * need to know if this character in source string is needed by the previous position, if not, we
 * should check if previous character in source has the character we need in this position. So we
 * can use a nested HashMap<TargetCharacter, HashMap<SourceCharacter, SourceIndex>> to record the
 * previous needed character and use a HashMap<SourceCharacter, index> to record the previous
 * characters in source string.
 */
public class MinStringDistance {
  public int[] minStringDistance(String src, String tar) {
    if (src.equals(tar)) {
      return new int[]{-1, -1};
    }

    HashMap<Character, HashMap<Character, Integer>> map = new HashMap<>();
    int[] srcHas = new int[26];

    int[] ans = new int[]{-1, -1};

    Arrays.fill(srcHas, -1);

    for (int i = 0; i < src.length(); i++) {
      char s = src.charAt(i);
      char t = tar.charAt(i);
      if (s != t) {
        if (map.containsKey(s)) {
          if (map.get(s).containsKey(t)) {
            return new int[]{map.get(s).get(t), i};
          }

          for (int n: map.get(s).values()) {
            ans[0] = n;
            break;
          }
          ans[1] = i;
        } else if (srcHas[t - 'a'] != -1){
          ans[0] = srcHas[t - 'a'];
          ans[1] = i;
        } else {
          srcHas[s - 'a'] = i;
          map.put(t, new HashMap<>());
          map.get(t).put(s, i);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    for (int n: new MinStringDistance().minStringDistance("abc", "cba")) {
      System.out.println(n);
    }
  }
}
