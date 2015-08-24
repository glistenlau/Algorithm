public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<HashSet<Integer>> map = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      map.add(new HashSet<>());
    }

    for (int[] pre: prerequisites) {
      map.get(pre[0]).add(pre[1]);
    }

    Queue<Integer> ready = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (map.get(i).isEmpty()) {
        ready.offer(i);
      }
    }

    while (!ready.isEmpty()) {
      int cur = ready.poll();

      for (int i = 0; i < numCourses; i++) {
        if (map.get(i).isEmpty()) {
          continue;
        }
        map.get(i).remove(cur);

        if (map.get(i).isEmpty()) {
          ready.offer(i);
        }
      }

    }

    for (int i = 0; i < numCourses; i++) {
      if (!map.get(i).isEmpty()) {
        return false;
      }
    }

    return true;
  }
}