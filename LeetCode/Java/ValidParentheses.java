import java.util.Stack;

/**
 * Created by root on 2/26/15.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1) return false;
        Stack<Character> check = new Stack<Character>();
        char[] news = s.toCharArray();
        for(int i = 0; i < len; i++){
            switch (news[i]){
                case '(':
                    check.push(')');
                    break;
                case '{':
                    check.push('}');
                    break;
                case '[':
                    check.push(']');
                    break;
                default:
                    if(check.isEmpty() || check.pop() != news[i] )
                        return false;
            }
        }
        if(check.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String test = args[0];
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(test));
    }
}
