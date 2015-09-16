/**
 * image mirror说白了就是将一个二维矩阵按照对称轴左右对称得到翻转的图形。这道题就是要注意因为矩阵里面每一个值都是由byte表示。但是我们用bit
 * 来表示一个像素点的话，需要同时把bit翻转。
 * 例如：
 *
 * This problem is to mirror an image, in the array, every element is a byte, and use bits to
 * represent pixel, we can mirror the image row by row, for each byte we swap with its symmetrical
 * element, and then mirror both element inside.
 */
public class MirrorImage {
  public void mirrorImage(char[][] image) {
    if (image == null || image.length == 0 || image[0].length == 0) {
      return;
    }

    for (int r = 0; r < image.length; r++) {
      int left = 0;
      int right = image[r].length - 1;
      while (left < right) {
        char temp = image[r][left];
        image[r][left] = image[r][right];
        image[r][right] = temp;

        image[r][left] = mirrorBits(image[r][left]);
        left++;
        image[r][right] = mirrorBits(image[r][right]);
        right--;
      }

      if (left == right) {
        image[r][left] = mirrorBits(image[r][left]);
      }
    }
  }


  private char mirrorBits(char c) {
    char ans = 0;
    for (int i = 0; i < 8; i++) {
      ans |= ((c >>> i) & 1) << (7 - i);
    }

    return ans;
  }

  public static void main(String[] args) {
    char[][] image = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    new MirrorImage().mirrorImage(image);
    System.out.println(image);
  }
}
