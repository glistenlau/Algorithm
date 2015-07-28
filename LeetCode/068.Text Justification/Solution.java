public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<String>();
    if (words == null || words.length == 0) {
      return result;
    }

    int i = 0;
    while (i < words.length) {
      i = dfsHelper(words, maxWidth, i, 0, new ArrayList<String>(), result) + 1;
    }
    return result;
  }

  private int dfsHelper(String[] words, int maxWidth, int pos, int width, ArrayList<String> taken, List<String> result) {

    if (width > maxWidth) {
      return -1;
    }
    if (pos == words.length) {
      result.add(generateString(taken, maxWidth, maxWidth));
      return pos - 1;
    }
    taken.add(words[pos]);
    int curtWidth = width == 0? width + words[pos].length(): width + words[pos].length() + 1;
    int re = dfsHelper(words, maxWidth, pos + 1, curtWidth, taken, result);
    taken.remove(taken.size() - 1);
    if (re == -1) {
      result.add(generateString(taken, maxWidth, width));
      return pos - 1;
    } else {
      return re;
    }
  }

  private String generateString(List<String> taken, int maxWidth, int width) {
    int i = 0;
    int n = taken.size();
    StringBuilder result = new StringBuilder();
    if (n == 1 || maxWidth == width) {
      result.append(taken.get(0));
      for (int k = 1; k < taken.size(); k++) {
        result.append(" " + taken.get(k));
      }
      while(result.length() < maxWidth) {
        result.append(" ");
      }
    } else {
      int spaceNum = maxWidth - (width - n + 1);
      int spaceAvg = spaceNum / (n - 1);
      int spaceMod = spaceNum % (n - 1);
      while(i < taken.size()) {
        int sn = spaceMod > 0? spaceAvg + 1: spaceAvg;
        result.append(taken.get(i++));
        if (i == taken.size()) {
          break;
        }
        for (int j = 0; j < sn; j++) {
          result.append(' ');
        }
        spaceMod--;
      }
    }

    return result.toString();
  }
}