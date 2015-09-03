/**
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary
 * that can start from any position in the matrix and go left/right/up/down to the adjacent
 * position.
 *
 * Example
 * Given matrix:
 *   doaf
 *   agai
 *   dcan
 *
 * and dictionary:
 * {"dog", "dad", "dgdg", "can", "again"}.
 *
 * return {"dog", "dad", "can", "again"}.
 *
 */
public class Solution {
  /**
   * @param board: A list of lists of character
   * @param words: A list of string
   * @return: A list of string
   */

  private class TrieNode {
    String s;
    TrieNode[] next;
    boolean hasEnd;

    TrieNode () {
      this.next = new TrieNode[26];
      this.hasEnd = false;
    }
  }

  private class Trie {
    TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    void insert(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next[c - 'a'] == null) {
          cur.next[c - 'a'] = new TrieNode();
        }
        cur = cur.next[c - 'a'];
      }
      cur.s = word;
      cur.hasEnd = true;
    }

    boolean search(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next[c - 'a'] == null) {
          return false;
        }
        cur = cur.next[c - 'a'];
      }
      return cur.hasEnd;
    }
  }


  public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
    // write your code here
    ArrayList<String> ans = new ArrayList<String>();
    if (board == null || board.length == 0 || board[0].length == 0) {
      return ans;
    }

    Trie dict = new Trie();
    for (String word: words) {
      dict.insert(word);
    }

    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        search(board, r, c, ans, new boolean[board.length][board[0].length], dict.root.next[board[r][c] - 'a']);
      }
    }

    return ans;
  }

  private void search(char[][] board, int row, int col, ArrayList<String> ans, boolean[][] visited, TrieNode root) {
    if (visited[row][col] || root == null) {
      return;
    }

    visited[row][col] = true;
    if (root.hasEnd) {
      if(!ans.contains(root.s)) {
        ans.add(root.s);
      }
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < 4; i++) {
      int r = row + dx[i];
      int c = col + dy[i];

      if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
        search(board, r, c, ans, visited, root.next[board[r][c] - 'a']);
      }
    }

    visited[row][col] = false;
  }
}
