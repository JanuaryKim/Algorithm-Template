import java.util.*;

class Solution {
    public int solution(String t, String p) {
        
        int result = 0;
        long intP = Long.parseLong(p);
        for(int i = 0; i <= t.length() - p.length(); i++)
        {
            String sub = t.substring(i,i+p.length());
            long intValue = Long.parseLong(sub);
            System.out.println(i);
            if(intValue <= intP)
                result++;
        }
        
        return result;
    }
}