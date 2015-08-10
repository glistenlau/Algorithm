public class Solution {
  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    Queue<Integer> myQ = new LinkedList<Integer>();

    for (int i = 0; i < m; i++) {
      enqueue(board, i, 0, myQ);
      enqueue(board, i, n - 1, myQ);
    }

    for (int j = 1; j < n; j++) {
      enqueue(board, 0, j, myQ);
      enqueue(board, m - 1, j, myQ);
    }

    while (!myQ.isEmpty()) {
      int curIndex = myQ.poll();
      int r = curIndex / n;
      int c = curIndex % n;

      board[r][c] = 'B';

      enqueue(board, r - 1, c, myQ);
      enqueue(board, r + 1, c, myQ);
      enqueue(board, r, c - 1, myQ);
      enqueue(board, r, c + 1, myQ);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'B') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void enqueue(char[][] board, int r, int c, Queue<Integer> myQ) {
    if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O') {
      myQ.offer(r * board[0].length + c);
    }
  }
}