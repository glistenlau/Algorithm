import java.util.Scanner;

/**
 * Created by yi on 4/13/15.
 */
public class atoi {
    private static final int MaxIntDiv10 = Integer.MAX_VALUE / 10;
    public int atoi(String str){
        int i = 0;
        int sign = 1;
        while(i < str.length() && str.charAt(i) == ' ')
            i++;
        if(str.charAt(i) == '+')
            i++;
        else if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            int bit = Character.getNumericValue(str.charAt(i));
            if(num > MaxIntDiv10 || (num == MaxIntDiv10 && bit >= 8)){
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            else
                num = num * 10 + bit;
            i++;
        }
        return sign * num;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        atoi test = new atoi();
        String s = in.nextLine();
        System.out.println(test.atoi(s));
    }
}
