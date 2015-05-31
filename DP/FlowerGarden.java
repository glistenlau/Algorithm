/**
 * Created by YiLIU on 5/29/15.
 */
public class FlowerGarden {
  public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
    int n = height.length;
    int[] order = new int[n];
    boolean[] ordered = new boolean[n];
    for (int i = 0; i < n; ++i) {
      int resonable = -1;
      int lowwest = -1;
      try_order:
      for (int j = 0; j < n; ++j) {
        if (ordered[j]) continue;
        if (height[j] <= lowwest) continue;
        for ( int k = 0; k < n; ++k) {
          if (ordered[k]) continue;
          if (height[k] >= height[j]) continue;
          if (bloom[k] <= wilt[j] && wilt[k] >= bloom[j]) continue try_order;
        }
        resonable = j;
        lowwest = height[j];
      }
      ordered[resonable] = true;
      order[i] = height[resonable];
    }
    return order;
  }

  public static void main(String[] args) {
    int[] height =
        {5,4,3,2,1};
    int[] bloom =
        {1,1,1,1,1};
    int[] wilt =
    {365,365,365,365,365};

    for (int flower : new FlowerGarden().getOrdering(height, bloom, wilt)) {
      System.out.println(flower);
    }
  }
}
