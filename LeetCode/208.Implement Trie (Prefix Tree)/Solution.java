class TrieNode {
  // Initialize your data structure here.
  boolean hasEnd;
  TrieNode[] next;
  TrieNode() {

    hasEnd = false;
    next = new TrieNode[26];
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      if (cur.next[word.charAt(i) - 'a'] == null) {
        cur.next[word.charAt(i) - 'a'] = new TrieNode();
      }
      cur = cur.next[word.charAt(i) - 'a'];
    }
    cur.hasEnd = true;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      if (cur.next[word.charAt(i) - 'a'] == null) {
        return false;
      }
      cur = cur.next[word.charAt(i) - 'a'];
    }
    return cur.hasEnd;
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (cur.next[prefix.charAt(i) - 'a'] == null) {
        return false;
      }
      cur = cur.next[prefix.charAt(i) - 'a'];
    }

    return true;
  }
}