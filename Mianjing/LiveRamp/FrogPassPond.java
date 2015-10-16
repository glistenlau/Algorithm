import java.util.Arrays;
import java.util.List;

/**
 * A small frog wants to get to the other side of a pond. The frog is initially located on one bank
 * of the pond(position 0) and wants to get to the other bank (position X). The frog can jump any
 * distance between 1 and D. I X > D then frog cannot jump right across the pond. Luckily, there
 * are leaves falling from a tree onto the surface of the pond, and the frog can jump onto and
 * from the leaves.
 *
 * You are given a zero-indexed array A consisting of N integers. This array represents falling
 * leaves. Initially there are no leaves. A[K] represents the position where a leaf will fall in
 * second K.
 *
 * The goal is to find the earliest time when the frog can get to the other side of the pond. The
 * frog can jump from and to positions 0 and X and every position with a leaf.
 *
 * For example, you have a given integers X = 7, D = 3 and array A such that:
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 5
 * Initially, the frog connot jump across the pond in a single jump. However, in second 3, after
 * a leaf falls at position 4, it becomes possible for the frog to cross. This is the earliest
 * moment when the frog can jump across the pond (by jumps of length 1, 3, and 3).
 *
 * Write a function:
 *   int solution(vector<int> &A, int x, int D);
 * that given a zero-indexed array A consisting of N integers, and integers X and D, returns the
 * earliest time when the frog can jump to the other side of the pond. If the frog can leap
 * across the pond in just one jump, the function should return 0. If the frog can get to the
 * other side of the pond just after the very first leaf fals, the function should also return 0.
 * If the frog is never able to jump to the other side of the pond, the function should return -1.
 */
public class FrogPassPond {
  public int earliestPass(List<Integer> A, int X, int D) {
    if (A == null || A.size() == 0 || X <= D) {
      return 0;
    }

    boolean[] hasLeaf = new boolean[X];
    int pos = 0;

    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) > pos) {
        hasLeaf[A.get(i)] = true;
        if (pos + D >= A.get(i)) {
          pos = getRomotestPos(pos, D, hasLeaf);
          if (pos + D >= X) {
            return i;
          }
        }
      }
    }

    return -1;
  }

  private int getRomotestPos(int pos, int D, boolean[] hasLeaf) {
    int next = pos;
    while (next + D < hasLeaf.length) {
      for (int i = D; i > 0; i--) {
        if (pos + i < hasLeaf.length && hasLeaf[pos + i]) {
          next = pos + i;
          break;
        }
      }
      if (next == pos) {
        return pos;
      } else {
        pos = next;
      }
    }

    return pos;
  }

  private class Bucket {
    int min;
    int max;
    boolean connectedPre;
    boolean connectedAft;
    Bucket(int num) {
      this.min = num;
      this.max = num;
      this.connectedPre = false;
      this.connectedAft = false;
    }
  }

  public int earliestPass2(List<Integer> A, int X, int D) {
    if (A == null || A.size() == 0 || X <= D) {
      return 0;
    }

    Bucket[] b = new Bucket[X / D];
    int connected = 0;

    for (int i = 0; i < A.size(); i++) {
      int cur = A.get(i);
      int index = cur / D;
      if (b[index] == null) {
        b[index] = new Bucket(cur);
        if (index == 0) {
          b[index].connectedPre = true;
        }
        if (index == X / D - 1) {
          b[index].connectedAft = true;
        }
      } else {
        b[index].min = Math.min(b[index].min, cur);
        b[index].max = Math.max(b[index].max, cur);
        if (!(b[index].connectedPre && b[index].connectedAft)) {
          if (index - 1 >= 0 && b[index - 1] != null) {
            b[index].connectedPre = b[index].min - D <= b[index - 1].max;
          }
          if (index + 1 < X / D && b[index + 1] != null) {
            b[index].connectedAft = b[index].max + D >= b[index + 1].min;
          }

          if (b[index].connectedPre && b[index].connectedAft) {
            connected++;
          }

          if (connected == X / D) {
            return i;
          }
        }
      }

    }

    return -1;
  }


  public static void main(String[] args) {
    System.out.println(new FrogPassPond().earliestPass2(Arrays.asList(1, 3, 1, 4, 2, 5), 7, 3));
  }
}
