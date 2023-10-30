import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        if(s.length() % 2 == 0) {
            int leng = s.length() / 2;
            sb.append(s.charAt(leng-1));
            sb.append(s.charAt(leng));
        }
        else {
            sb.append(s.charAt(s.length() / 2));
        }
        return sb.toString();
    }
}