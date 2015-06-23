/**
 * Created by yi on 4/12/15.
 */
public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ; i++){
            for(int j = 0; ;j++){
                if(j == needle.length())
                    return i;
                if(i + j == haystack.length())
                    return -1;
                if(haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
        }
    }
}
