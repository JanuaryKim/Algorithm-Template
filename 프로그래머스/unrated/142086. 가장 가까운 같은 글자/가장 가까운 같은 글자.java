import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            Integer value = map.get(c);
            if(value == null)
                result[i] = -1;
            else
                result[i] = i - value;
            map.put(c, i);
        }
        
        return result;
    }
}