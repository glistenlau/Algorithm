
// Solution 1:
public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int maxArea = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          maxArea = Math.max(expand(matrix, i, j), maxArea);
        }
      }
    }

    return maxArea;
  }

  private int expand(char[][] matrix, int row, int col) {
    int maxArea = 1;
    int end = matrix[0].length;
    for (int r = row; r < matrix.length; r++) {
      int start = col;
      for (; start < end; start++) {
        if (matrix[r][start] == '0') {
          break;
        }
      }
      maxArea = Math.max(maxArea, (r - row + 1) * (start - col));
      end = start;
    }
    return maxArea;
  }
}

// Solution 2:
public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int maxArea = 0;
    int[] histogram = new int[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          histogram[j] = 0;
        } else {
          histogram[j] = histogram[j] + 1;
        }
      }

      maxArea = Math.max(maxArea, maxHistogram(histogram));
    }

    return maxArea;
  }

  private int maxHistogram(int[] height) {
    int maxArea = 0;
    Stack<Integer> myStack = new Stack<Integer>();

    for (int i = 0; i <= height.length; i++) {
      int aft = i == height.length? Integer.MIN_VALUE: height[i];
      while (!myStack.isEmpty() && aft < height[myStack.peek()]) {
        int h = height[myStack.pop()];
        int w = myStack.isEmpty()? i: i - myStack.peek() - 1;
        maxArea = Math.max(maxArea, h * w);
      }
      myStack.push(i);
    }
    return maxArea;
  }
}