import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Map<String,Integer>[] maps = new Map[2];
        int[] mapsIdx = new int[2];
        Arrays.fill(mapsIdx,-1);
        
        maps[0] = new HashMap<>();    
        for(int i = 0; i < cards1.length; i++)
        {
            maps[0].put(cards1[i],i);
        }
        
        maps[1] = new HashMap<>();            
        for(int i = 0; i < cards2.length; i++)
        {
            maps[1].put(cards2[i],i);
        }
        
        for(int i = 0; i < goal.length; i++)
        {
            String str = goal[i];
            
            for(int j = 0; j < maps.length; j++)
            {
                Integer idx = maps[j].get(str);
                if(idx != null)
                {
                    
                    if(idx - mapsIdx[j] != 1 || mapsIdx[j] > idx) {
                        return "No";
                    }
                    mapsIdx[j] = idx;
                }
            }
        }
        return "Yes";
    }
}