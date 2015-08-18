public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int left = 1;
    int right = Integer.MAX_VALUE - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (canSurvival(mid, dungeon)) {
        right = mid;
      } else {
        left = mid;
      }
    }

    if (canSurvival(left, dungeon)) {
      return left;
    }
    return right;
  }

  private boolean canSurvival(int health, int[][] dungeon) {
    int[][] healthLeft = new int[dungeon.length][dungeon[0].length];
    healthLeft[0][0] = health + dungeon[0][0];

    for (int i = 0; i < dungeon.length; i++) {
      for (int j = 0; j < dungeon[0].length; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int left = j > 0 && healthLeft[i][j - 1] > 0? healthLeft[i][j - 1]: Integer.MIN_VALUE;
        int up = i > 0 && healthLeft[i - 1][j] > 0? healthLeft[i - 1][j]: Integer.MIN_VALUE;
        healthLeft[i][j] = left < 1 && up < 1? Integer.MIN_VALUE: Math.max(left, up) + dungeon[i][j];
      }
    }

    return healthLeft[dungeon.length - 1][dungeon[0].length - 1] > 0;
  }
}