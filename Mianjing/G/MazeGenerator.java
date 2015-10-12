import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

/**
 * Created by YiLIU on 10/11/15.
 */
public class MazeGenerator extends Canvas {
  private final static int[] dx = {0, 0, -1, 1};
  private static final int[] dy = {1, -1, 0, 0};
  private Cell[][] maze;

  private class Cell {
    boolean visited;
    boolean top;
    boolean bottom;
    boolean left;
    boolean right;

    Cell() {
      this.visited = false;
      this.top = true;
      this.bottom = true;
      this.left = true;
      this.right = true;
    }

    public List<Line2D> paint(int x, int y) {
      List<Line2D> lines = new ArrayList<Line2D>();
      if (top) {
        lines.add(new Line2D.Double(x - 5, y + 5, x + 5, y + 5));
      }
      if (bottom) {
        lines.add(new Line2D.Double(x - 5, y - 5, x + 5, y - 5));
      }
      if (left) {
        lines.add(new Line2D.Double(x - 5, y + 5, x - 5, y - 5));
      }
      if (right) {
        lines.add(new Line2D.Double(x + 5, y + 5, x + 5, y - 5));
      }

      return lines;
    }
  }

  public Cell[][]mazeGenerator() {
    HashSet<Cell> visited = new HashSet<>();
    dfs(maze, 0, 0, visited);

    return maze;
  }

  private void dfs(Cell[][] maze, int row, int col, HashSet<Cell> visited) {
    if (visited.contains(maze[row][col])) {
      return;
    }

    visited.add(maze[row][col]);
    List<Integer> neighbors = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
      int r = row + dx[i];
      int c = col + dy[i];
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
        if (!visited.contains(maze[r][c])) {
          neighbors.add(r * maze[0].length + c);
        }
      }
    }

    if (neighbors.size() == 0) {
      return;
    }

    while(!neighbors.isEmpty()) {
      int next = (int) (Math.random() * neighbors.size());
      int r = neighbors.get(next) / maze[0].length;
      int c = neighbors.get(next) % maze[0].length;
      if (!visited.contains(maze[r][c])) {
        removeWall(maze, row, col, r, c);
        dfs(maze, r, c, visited);
      }
      neighbors.remove(next);
      if (visited.size() == maze.length * maze.length) {
        return;
      }
    }
  }

  private void removeWall(Cell[][] maze, int row, int col, int r, int c) {
    int i = 0;
    for (; i < 4; i++) {
      if (row + dx[i] == r && col + dy[i] == c) {
        break;
      }
    }

    if (i == 0) {
      maze[row][col].top = false;
      maze[r][c].bottom = false;
    } else if (i == 1) {
      maze[row][col].bottom = false;
      maze[r][c].top = false;
    } else if (i == 2) {
      maze[row][col].left = false;
      maze[r][c].right = false;
    } else if (i == 3) {
      maze[row][col].right = false;
      maze[r][c].left = false;
    }
  }


  public MazeGenerator(int n) {
    this.setBackground(Color.WHITE);
    maze = new Cell[n][n];
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        maze[r][c] = new Cell();
      }
    }
  }

  @Override
  public void paint(Graphics g) {
    drawMaze(g);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(10 * maze.length + 20, 10 * maze.length + 20);
  }

  private void drawMaze(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(Color.BLACK);
    g2d.setStroke(new BasicStroke(3));

    int x = 15;
    int y = 15;

    List<Line2D> lines = new ArrayList<>();

    for (int r = 0; r < maze.length; r++) {
      for (int c = 0; c < maze.length; c++) {
        lines.addAll(maze[r][c].paint(x, y));
        y += 10;
      }
      y = 15;
      x += 10;
    }

    for (Line2D line: lines) {
      g2d.draw(line);
    }
  }




  public static void main(String[] args) {
    MazeGenerator mg = new MazeGenerator(80);
    Cell[][] result = mg.mazeGenerator();
    Frame frame = new Frame("Maze");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.add(mg, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

}
