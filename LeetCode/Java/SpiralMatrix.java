import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yi on 5/6/15.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                matrix[i][j] = in.nextInt();
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int c = matrix.length;
        if (c == 0) return result;
        int r = matrix[0].length;
        int row = 0, col = -1;
        while (true) {
            for (int i = 0; i < r; ++i)
                result.add(matrix[row][++col]);
            if (--c == 0) break;
            for (int i = 0; i < c; ++i)
                result.add(matrix[++row][col]);
            if (--r == 0) break;
            for (int i = 0; i < r; ++i)
                result.add(matrix[row][--col]);
            if (--c == 0) break;
            for (int i = 0; i < c; ++i)
                result.add(matrix[--row][col]);
            if (--r == 0) break;
        }
        return result;
    }
}
