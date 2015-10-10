import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个以String形式存储的文件，每行有一些字符串，结尾是\n，然后给你一个offset，问是在第几行。
 * 比如：
 * abc\n
 * de\n
 * efg\n
 * h\n
 * offset = 0 的话是a，在第1行。offset = 3 为\n，还在第一行。offset = 8 是f，在第三行。
 *
 * 非常简单的题目，用循环做就行，每次遇到一个\n就加1，注意不要count最后一个字母，因为可能是结尾的\n。
 * follow up：
 * 接上题，让你设计一种数据结构，用比O(n)快的方法找到line number。
 */
public class LineLocation {
  public int lineLocation(String str, int offset) {
    if (str == null || str.length() == 0 || str.length() < offset) {
      return -1;
    }

    int line = 1;
    for (int i = 0; i <= offset; i++) {
      if (i > 0 && str.charAt(i - 1) == '\n') {
        line++;
      }
    }

    return line;
  }


  public int followupSolution(String str, int offset) {
    List<Integer> sum = new ArrayList<>();

    int line = 0;
    for (int i = 0; i < str.length(); i++) {
      if (i > 0 && str.charAt(i - 1) == '\n') {
        line++;
      }
      if (sum.size() - 1 < line) {
        sum.add(line == 0 ? 0: sum.get(line - 1));
      }

      sum.set(line, sum.get(line) + 1);
    }

    return binarySearch(sum, offset + 1) + 1;

  }

  private int binarySearch(List<Integer> sum, int tar) {
    int left = 0;
    int right = sum.size() - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;

      if (sum.get(mid) == tar) {
        return mid;
      } else if (sum.get(mid) < tar) {
        left = mid;
      } else if (sum.get(mid) > tar) {
        right = mid;
      }

    }

    if (sum.get(left) >= tar) {
      return left;
    }

    return right;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 9; i++) {
      System.out.print(new LineLocation().lineLocation("abc\nde\nf\n", i));
      System.out.println(new LineLocation().followupSolution("abc\nde\nf\n", i));

    }
  }

}
