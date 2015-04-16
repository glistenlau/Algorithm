import java.util.Scanner;

/**
 * Created by yi on 4/14/15.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        boolean isValid = false;
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        while(i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isValid = true;
        }
        if(i < n && (s.charAt(i) == '.')){
            i++;
            while(i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isValid = true;
            }
        }
        if(isValid && i < n && (s.charAt(i) == 'e')){
            i++;
            isValid = false;
            if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while(i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isValid = true;
            }
        }
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isValid && i == n;
    }


    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ValidNumber test = new ValidNumber();
        while(true) {
            String s = in.nextLine();
            System.out.println(test.isNumber(s));
        }
    }
}
