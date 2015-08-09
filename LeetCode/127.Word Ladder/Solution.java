public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    Queue<String> myQ = new LinkedList<String>();
    myQ.offer(beginWord);
    wordDict.remove(beginWord);
    int len = 1;

    while (!myQ.isEmpty()) {
      int size = myQ.size();

      for (int i = 0; i < size; i++) {
        char[] chars = myQ.poll().toCharArray();

        for (int n = 0; n < chars.length; n++) {
          char pre = chars[n];
          for (char c = 'a'; c <= 'z'; c++) {
            chars[n] = c;
            String newStr = new String(chars);
            if (newStr.equals(endWord)) {
              return len + 1;
            }
            if (wordDict.contains(newStr)) {
              wordDict.remove(newStr);
              myQ.offer(newStr);
            }
          }
          chars[n] = pre;
        }
      }

      len++;
    }

    return 0;
  }
}