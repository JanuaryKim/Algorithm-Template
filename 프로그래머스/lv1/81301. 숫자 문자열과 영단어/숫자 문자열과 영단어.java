import java.util.*;

class Solution {
    public int solution(String s) {
        
        String[] digitStr = new String[]
        {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < digitStr.length; i++)
        {
            s = s.replaceAll(digitStr[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}