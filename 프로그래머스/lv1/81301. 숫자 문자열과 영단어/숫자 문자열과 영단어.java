import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9')
            {
                sb.append(c);
                continue;
            }
            
            tempSb.append(c);
            Integer value = map.get(tempSb.toString());
            if(value != null)
            {
                sb.append(value);
                tempSb.setLength(0);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}