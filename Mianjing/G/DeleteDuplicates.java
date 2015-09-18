/**
 * Given a string which only contains lowercase. You need delete the repeated letters only leave
 * one, and try to make the lexicographical order of new string is smallest.
 *
 * ie.
 * bcabc
 * You need delete 1 'b', 1 'c', so you delete the first 'b' and first 'c', the new string will
 * be abc which is smallest.
 *
 * My idea is use a hashtable to record the frequence of each character, use a variable to know
 * what's the current smallest character, then traverse the string, if we got a character whose
 * count is 1, append to the result, if we got a current smallest character, append to the result
 * and get the next smallest character. if current character is smaller than the next, and next
 * count is 1, append this character.
 */
public class DeleteDuplicates {
  public String deleteDuplicates(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }

    int[] freq = new int[26];

    for (int i = 0; i < str.length(); i++) {
      freq[str.charAt(i) - 'a']++;
    }

    char smallest = 'z';
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char cur = str.charAt(i);
      if (freq[cur - 'a'] == 0) {
        continue;
      }

      smallest = cur < smallest? cur: smallest;

      if (freq[cur - 'a'] == 1) {
        if (cur >= smallest) {
          ans.append(smallest);
          freq[smallest - 'a'] = 0;
          if (cur != smallest) {
            ans.append(cur);
          }
          smallest = 'z';
        } else {
          ans.append(cur);
        }

      }
      --freq[cur - 'a'];
    }


    return ans.toString();
  }

  public static void main(String[] args) {
    String str = "cbacdcbc";
    String str1 = "bcabc";

    System.out.println(new DeleteDuplicates().deleteDuplicates(str1));
  }
}
