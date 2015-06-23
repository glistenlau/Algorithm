import java.util.Scanner;

/**
 * Created by Yi on 4/17/2015.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        String m = s.length() > t.length() ? s : t;
        String n = s.length() > t.length() ? t : s;
        int count = 0;
        int i = 0;
        int j = 0;
        if(m.length() - n.length() > 1)
            return false;
        else
            while(j < n.length()) {
                if(m.charAt(i) == n.charAt(j))
                    j++;
                else {
                    count++;
                    if(m.length() == n.length())
                        j++;
                }
                i++;
            }
        if(i == n.length()) return count == 0;
        return count == 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OneEditDistance test = new OneEditDistance();
        String s = in.nextLine();
        String t = in.nextLine();
        System.out.println(test.isOneEditDistance(s, t));
    }
}
