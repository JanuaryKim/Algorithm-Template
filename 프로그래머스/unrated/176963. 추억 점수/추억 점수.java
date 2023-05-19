import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> yearningMap = new HashMap<>();
        
        for(int i = 0; i < name.length; i++)
        {
            yearningMap.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        Arrays.fill(result,0);
        
        for(int i = 0; i < photo.length; i++)
        {
            String[] ph = photo[i];
            
            for(int j = 0; j < ph.length; j++)
            {
                if(yearningMap.get(ph[j]) != null)
                    result[i] += yearningMap.get(ph[j]);
            }
        }
        
        return result;
    }
}