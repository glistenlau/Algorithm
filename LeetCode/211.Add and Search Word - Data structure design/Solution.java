public class WordDictionary {
  private class Trie {
    Trie[] next;
    boolean end;

    Trie() {
      next = new Trie[26];
      boolean end = false;
    }
  }

  private Trie root;

  public WordDictionary() {
    root = new Trie();
  }

  public void addWord(String word) {
    Trie cur = root;
    for (int i = 0; i < word.length(); i++) {
      if (cur.next[word.charAt(i) - 'a'] == null) {
        cur.next[word.charAt(i) - 'a'] = new Trie();
      }

      cur = cur.next[word.charAt(i) - 'a'];
    }

    cur.end = true;
  }

  public boolean search(String word) {
    Trie cur = root;
    return search(word, cur);
  }

  public boolean search(String word, Trie r) {
    if (word.length() == 0) {
      return r.end;
    }
    Trie cur = r;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (int j = 0; j < 26; j++) {
          if (cur.next[j] != null && search(word.substring(i + 1), cur.next[j])) {
            return true;
          }
        }

        return false;
      } else {
        if (cur.next[c - 'a'] == null) {
          return false;
        }
      }
      cur = cur.next[c - 'a'];
    }

    return cur.end;
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");