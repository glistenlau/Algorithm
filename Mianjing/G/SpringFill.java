import java.util.*;

/**
 * 小哥首先问我c++有什么缺点。没准备脑子堵了 说一点 然后就没了
 第二道题有点像lc的 trapping raining water。（考之前还想刷一篇来着）
 但是又不同
 给两个vector 一个是地面的高度，一个是泉水的位置，那些index的地面不能被泉水fill。return那些index。
 举个例子。
 ----       -----. 1point 3acres 璁哄潧
 |      |
 |_*__|
 *是泉水的位置
 输入input array是 地表 2，0，2
 泉水 1（表示index1上有）
 那么output是0 2

 在假设地表是 2 1 0 2
 泉水是 2。
 那么输出是 0 3 因为在2的泉水可以覆盖index1 但是由于漫不u过index0

 写完后debug了一下 还被小哥找出两个bug 问了下running time 时间就结束了。。。第二题都还没问呢 感觉惨惨的。. 1point 3acres 璁哄潧
 保佑拿到onsite，攒人品
 */
public class SpringFill {
 public List<Integer> springFill(int[] ground, int[] spring) {
  List<Integer> ans = new ArrayList<>();
  if (ground == null || ground.length == 0) {
   return ans;
  }
  if (spring == null || spring.length == 0) {
    new ArrayList<>(Arrays.asList(ground));
  }

  boolean[] groundHasSpring = new boolean[ground.length];
  for (int i: spring) {
   groundHasSpring[i] = true;
  }

  Stack<Integer> left = new Stack<>();
  for (int i = 0; i < ground.length; i++) {
   if (groundHasSpring[i]) {
    while (!left.isEmpty() && ground[i] > ground[left.peek()]) {
     left.pop();
    }
   }

   left.push(i);
  }

  Stack<Integer> right = new Stack<>();
  for (int i = ground.length - 1; i >= 0; i--) {
   if (groundHasSpring[i]) {
    while (!right.isEmpty() && ground[i] > ground[right.peek()]) {
     right.pop();
    }
   }

   right.push(i);
  }

  HashSet<Integer> hasNotSpring = new HashSet<>(left);
  hasNotSpring.retainAll(right);

  for (int index: hasNotSpring) {
   if (!groundHasSpring[index]) {
    ans.add(index);
   }
  }
  return ans;
 }


 public List<Integer> springFillB(int[] grounds, int[] springs) {
  List<Integer> ans = new ArrayList<>();
  if (springs == null || springs.length == 0) {
   return ans;
  }
  if (grounds == null || grounds.length == 0) {
   return ans;
  }

  for (int spring: springs) {
   findLeft(grounds, spring);
   findRight(grounds, spring);
  }

  for (int i = 0; i < grounds.length; i++) {
   if (grounds[i] != -1) {
    ans.add(i);
   }
  }

  return ans;
 }

 private void findLeft(int[] grounds, int right) {
  if (grounds[right] == -1) {
   return;
  }
  for (int i = right - 1; i >= 0; i--) {
   if (grounds[i] <= grounds[right]) {
    grounds[i] = -1;
   } else {
    break;
   }
  }
  grounds[right] = -1;
 }

 private void findRight(int[] grounds, int left) {
  if (grounds[left] == -1) {
   return;
  }
  for (int i = left + 1; i < grounds.length; i++) {
   if (grounds[i] <= grounds[left]) {
    grounds[i] = -1;
   } else {
    break;
   }
  }

  grounds[left] = -1;
 }

 public static void main(String[] args) {
  System.out.println(new SpringFill().springFill(new int[]{2, 0, 1, 2}, new int[]{2}));
  System.out.println(new SpringFill().springFillB(new int[]{2, 0, 1, 2}, new int[]{2}));
 }
}
