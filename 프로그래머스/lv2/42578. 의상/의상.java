import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int result = 1;
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++)
        {
            String type = clothes[i][1];
            Integer ctn = map.get(type);
            if(ctn == null){
                map.put(type, 2);
            }
            else{
                map.put(type, ctn+1);
            }
        }
        
        
        
        for(String key : map.keySet())
        {
            result *= map.get(key);
        }
        
        return result - 1;
    }
}