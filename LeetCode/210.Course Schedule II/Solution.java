public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> map = new ArrayList<>();
    int[] need = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      map.add(new ArrayList<>());
    }

    for (int[] pre: prerequisites) {
      map.get(pre[1]).add(pre[0]);
      need[pre[0]]++;
    }

    int[] ans = new int[numCourses];
    int index = 0;
    Queue<Integer> ready = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (need[i] == 0) {
        ans[index++] = i;
        ready.offer(i);
      }
    }

    while (!ready.isEmpty()) {
      int cur = ready.poll();
      for (int i: map.get(cur)) {
        if (--need[i] == 0) {
          ready.offer(i);
          ans[index++] = i;
        }
      }
    }

    for (int n: need) {
      if (n > 0) {
        return new int[0];
      }
    }

    return ans;
  }
}