public class Solution {

  private class TrieNode {
    TrieNode[] next;
    boolean end;

    TrieNode() {
      next = new TrieNode[26];
      end = false;
    }
  }

  private class Trie{

    TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    void addWord(String word) {
      TrieNode cur = root;
      for (int i = 0 ; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next[c - 'a'] == null) {
          cur.next[c - 'a'] = new TrieNode();
        }
        cur = cur.next[c - 'a'];
      }

      cur.end = true;
    }

    boolean hasWord(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next[c - 'a'] == null) {
          return false;
        }
        cur = cur.next[c - 'a'];
      }

      return cur.end;
    }

    boolean hasPrefix(String prefix) {
      TrieNode cur = root;
      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);
        if (cur.next[c - 'a'] == null) {
          return false;
        }

        cur = cur.next[c - 'a'];
      }

      return true;
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    HashSet<String> ans = new HashSet<>();
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }

    Trie dict = new Trie();

    for (String word: words) {
      dict.addWord(word);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i * board[0].length + j, dict, new HashSet<>(), new StringBuilder(), ans);
      }
    }

    return new ArrayList<>(ans);
  }

  private void dfs(char[][] board, int pos, Trie dict, HashSet<Integer> visited, StringBuilder taken, HashSet<String> ans) {
    if ((taken.length() > 0 && !dict.hasPrefix(taken.toString())) || visited.contains(pos)) {
      return;
    }


    int m = board.length;
    int n = board[0].length;
    int r = pos / n;
    int c = pos % n;
    taken.append(board[r][c]);
    visited.add(pos);
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    for (int i = 0; i < 4; i++) {
      int row = r + dx[i];
      int col = c + dy[i];
      if (row >= 0 && row < m && col >= 0 && col < n) {
        dfs(board, row * n + col, dict, visited, taken, ans);
      }
    }
    if (dict.hasWord(taken.toString())) {
      ans.add(taken.toString());
    }
    visited.remove(pos);
    taken.deleteCharAt(taken.length() - 1);
  }
}