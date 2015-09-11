import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * struct LogEntry{
 *   string candidate; 投票姓名 int time; 投票时间
 * };
 * string findWinner(int time, vector<LogEntry> &logs);
 * 让找出在这个时间时候的 winner, c1(1), c2(2), c1(2), c2(3),c2(4) 括号里是投票时间。 所以
 * findWinner(2, logs) = c1;
 * findWinner(4, logs) = c2;
 *
 * 用hashMap, 记录小于等于给的时间的每个人的票数， 取最大值。
 */
public class VoteWinner {
  private static class LogEntry {
    String candidate;
    int time;
    LogEntry(String candidate, int time) {
      this.candidate = candidate;
      this.time = time;
    }
  }
  // Solution 1:
  public String maxVoteWinner(int time, ArrayList<LogEntry> logs) {
    if (logs == null || logs.size() == 0) {
      return "";
    }

    HashMap<String, Integer> map = new HashMap<>();

    for (LogEntry le : logs) {
      if (le.time > time) {
        continue;
      }
      if (!map.containsKey(le.candidate)) {
        map.put(le.candidate, 0);
      }

      map.put(le.candidate, map.get(le.candidate) + 1);
    }

    String ans = "";
    int max = 0;
    for (String can : map.keySet()) {
      if (map.get(can) > max) {
        ans = can;
        max = map.get(can);
      }
    }

    return ans;
  }

  /**
   * Follow up: 给一个时间， 找出前k个winner。
   *
   * follow up的解法就是在前一题的HashMap的基础上进行quicksort取前k个。
   */
  private class voteCount {
    String candidate;
    int count;
    voteCount(String candidate, int count) {
      this.candidate = candidate;
      this.count = count;
    }
  }

  public ArrayList<String> topKVoteWinner(int time, ArrayList<LogEntry> logs, int k) {
    if (logs == null || logs.size() == 0 || k < 1) {
      return new ArrayList<>();
    }

    HashMap<String, voteCount> map = new HashMap<>();

    for (LogEntry log: logs) {
      if (log.time > time) {
        continue;
      }

      if (!map.containsKey(log.candidate)) {
        map.put(log.candidate, new voteCount(log.candidate, 0));
      }

      map.get(log.candidate).count += 1;
    }

    ArrayList<voteCount> votes = new ArrayList<>(map.values());
    quickSelect(votes, k, 0, votes.size() - 1);
    ArrayList<String> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ans.add(votes.get(i).candidate);
    }

    return ans;
  }

  private void quickSelect(ArrayList<voteCount> votes, int k, int l, int r) {
    if (l >= r) {
      return;
    }
    int pivot = votes.get(l + (r - l) / 2).count;
    int left = l;
    int right = r;
    while (left <= right) {
      while (left <= right && votes.get(left).count > pivot) {
        left++;
      }
      while (left <= right && votes.get(right).count < pivot) {
        right--;
      }

      if (left <= right) {
        swap(votes, left++, right--);
      }
    }

    if (right <= k) {
      quickSelect(votes, k, l, right);
    }
    if (left >= k) {
      quickSelect(votes, k, left, r);
    }
  }

  private void swap(ArrayList<voteCount> arr, int a, int b) {
    voteCount temp = arr.get(a);
    arr.set(a, arr.get(b));
    arr.set(b, temp);
  }

  public static void main(String[] args) {
    ArrayList<LogEntry> logs = new ArrayList<LogEntry>(Arrays.asList(new LogEntry("Tom", 1), new
        LogEntry("Tom", 2), new LogEntry("Jim", 1), new LogEntry("Jim", 2), new LogEntry("Jim",
        2), new LogEntry("Bob", 1)));

    System.out.println(new VoteWinner().topKVoteWinner(2, logs, 3));
  }


}
