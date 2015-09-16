import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Give a target string and list of strings, find the longest string that has target as prefix,
 * follow up, stream of target string.
 *
 * The basic idea is compare everyone to find the longest. The time complexity is O(mn), n is the
 * number of strings, and m is the target length. It's brute force, but it may be the best
 * solution for any worst case.
 *
 * For the follow up, it can be solved by Trie tree, put all string to the trie tree, one target
 * character come, based on that character to find the longest string by using dfs. The time
 * complexity is O(mn), but it can be optimized by recording the longest length for each node
 * when building the trie tree. its time complexity is O(m + n).
*/
public class LongestPrefix {
  private class TrieNode{
    char val;
    String prefix;
    boolean hasEnd;
    HashMap<Character, TrieNode> children;
    String longestStr;

    TrieNode(char val, String prefix) {
      this.val = val;
      this.prefix = prefix;
      this.hasEnd = false;
      this.children = new HashMap<>();
      this.longestStr = new String();
    }
  }

  private class Trie {
    TrieNode root;

    Trie() {
      this.root = new TrieNode('^', "");
    }

    void insert(String word) {
      TrieNode temp = root;
      for (int i = 0; i < word.length(); i++) {
        if (!temp.children.containsKey(word.charAt(i))) {
          temp.children.put(word.charAt(i), new TrieNode(word.charAt(i), temp.prefix + word.charAt(i)));
        }

        temp = temp.children.get(word.charAt(i));
        if (word.length() > temp.longestStr.length()) {
          temp.longestStr = word;
        }
      }

      temp.hasEnd = true;
    }

    String getLonggestWithPrefix(String prefix) {
      TrieNode temp = root;
      for (int i = 0; i < prefix.length(); i++) {
        if (temp.children.containsKey(prefix.charAt(i))) {
          temp = temp.children.get(prefix.charAt(i));
        } else {
          return null;
        }
      }

      return temp.longestStr;
    }

  }

  public String LongestPrefix(List<String> strs, String tar) {
    if (strs == null || strs.size() == 0) {
      return "";
    }

    String ans = new String();

    for (String str: strs) {
      if (hasPrefix(str, tar) && str.length() > ans.length()) {
        ans = str;
      }
    }

    return ans;
  }

  private boolean hasPrefix(String str, String prefix) {
    if (str.length() < prefix.length()) {
      return false;
    }
    for (int i = 0; i < prefix.length(); i++) {
      if (str.charAt(i) != prefix.charAt(i)) {
        return false;
      }
    }

    return true;
  }

  public List<String> streamLonggestPrefix(List<String> strs, Stream<String> tar) {
    if (strs == null || strs.size() == 0) {
      return new ArrayList<>();
    }

    Trie dict = new Trie();
    for (String str: strs) {
      dict.insert(str);
    }

    List<String> ans = tar.parallel().
        map(prefix -> {
          return dict.getLonggestWithPrefix(prefix);
        }).
        collect(Collectors.toList());

    return ans;

 }

  public static void main(String[] args) {
    ArrayList<String> strs = new ArrayList<String>(Arrays.asList("hello", "help", "why", "hex",
        "yes", "holo"));
    System.out.println(new LongestPrefix().streamLonggestPrefix(strs, Stream.of("ho", "h", "he",
        "w", "z")));
  }
}
