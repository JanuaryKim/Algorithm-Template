import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Map<String, Integer> map = new HashMap<>();
        String[] strArr = new String[26-skip.length()];
        
        int asc = (int)'a';
        int idx = 0; 
        while(asc <= 'z')
        {
            String str = String.valueOf((char)asc);
            asc++;
            if(skip.contains(str))
                continue;
            else {
                map.put(str, idx);
                strArr[idx++] = str;
            }
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int rIdx = map.get(String.valueOf(c));
            int tempIdx = rIdx + index; 
            int nextIdx = tempIdx >= map.size() ? tempIdx % map.size() : tempIdx; 
            sb.append(strArr[nextIdx]);
        }
        
        return sb.toString();
    }
}