import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++)
        {
            int ctn = map.getOrDefault(clothes[i][1], 0);
            map.put(clothes[i][1], ctn + 1);
        }
        
        int result = 1;
        for(String key : map.keySet())
        {
            int ctn = map.get(key);
            result *= ctn + 1;
        }
        
        return result - 1;
    }
}