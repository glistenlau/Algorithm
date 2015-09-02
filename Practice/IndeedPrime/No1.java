package IndeedPrime;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by YiLIU on 9/1/15.
 */
public class No1 {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    ArrayList<Integer> stack = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      String op = in.next();
      if (op.equals("push")) {
        stack.add(in.nextInt());
      } else if (op.equals("pop")) {
        stack.remove(stack.size() - 1);
      } else {
        int n = in.nextInt();
        int val = in.nextInt();
        for (int j = 0; j < n && j < stack.size(); j++) {
          stack.set(j, stack.get(j) + val);
        }
      }
      System.out.println(stack.isEmpty()? "EMPTY": stack.get(stack.size() - 1));
    }
  }
}
